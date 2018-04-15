package tutorial;

import org.junit.Test;
import tutorial.model.Employee;
import tutorial.model.Workplace;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class OfficeTest {

    public static final String OFFICE_NAME = "TEST_OFFICE";

    @Test
    public void when_two_workspaces_is_added_make_sure_that_they_are_added() throws Exception {
       Office office = office();

       office.addWorkplace(availableWorkplace1());
       office.addWorkplace(availableWorkplace2());

       assertThat(office.getWorkplaces().size(), is(2));
    }

    @Test
    public void when_two_available_workspaces_is_added_make_sure_that_they_are_two_available_workplaces() throws Exception {
        Office office = office();

        office.addWorkplace(availableWorkplace1());
        office.addWorkplace(availableWorkplace2());

        assertThat(office.getAvailableWorkplaces().size(), is(2));
    }

    @Test
    public void when_one_available_workspace_and_one_taken_is_added_make_sure_that_they_is_one_available_workplace() throws Exception {
        Office office = office();

        office.addWorkplace(takenWorkplace1());
        office.addWorkplace(availableWorkplace2());

        assertThat(office.getAvailableWorkplaces().size(), is(1));
    }

    @Test
    public void when_workplace_is_destroyed_workplaces_should_not_contain_that_workplace() throws Exception {
        Office office = office();

        Workplace workplace = availableWorkplace1();

        office.addWorkplace(availableWorkplace1());
        office.addWorkplace(workplace);
        office.destroyWorkplace(workplace);

        assertFalse(office.getWorkplaces().isEmpty());
        assertThat(office.getWorkplaces(), not(hasItem(workplace)));
    }

    @Test
    public void when_all_added_workplaces_are_destroyed_workplaces_should_be_empty() throws Exception {
        Office office = office();

        Workplace workplace1 = availableWorkplace1();
        Workplace workplace2 = availableWorkplace2();

        office.addWorkplace(workplace1);
        office.addWorkplace(workplace2);
        office.destroyWorkplace(workplace1);
        office.destroyWorkplace(workplace2);

        assertTrue(office.getWorkplaces().isEmpty());
    }


    @Test
    public void when_workplace_is_reserved_for_employee_name_of_reserving_person_should_be_name_of_employee() {
        Office office = office();

        Employee employee = employee1();
        Workplace workplace = availableWorkplace1();

        office.addWorkplace(workplace);
        office.book(workplace, employee);

        assertThat(office.getWorkplacesOfEmployee(employee).size(), is(1));
        assertThat(office.getWorkplacesOfEmployee(employee).get(0).getEmployee().getName(), is(employee.getName()));
    }

    @Test
    public void when_workplace_is_reserved_for_employee1_and_then_reserved_for_employee2_name_of_reserving_person_should_be_name_of_employee2() {
        Office office = office();

        Employee employee1 = employee1();
        Employee employee2 = employee2();
        Workplace workplace = availableWorkplace1();

        office.addWorkplace(workplace);
        office.book(workplace, employee1);
        boolean success = office.book(workplace, employee2);
        assertFalse(success);
    }

    @Test
    public void when_workplace_is_reserved_it_can_be_canceled() {
        Office office = office();

        Employee employee1 = employee1();
        Workplace workplace = availableWorkplace1();

        office.addWorkplace(workplace);
        office.book(workplace, employee1);
        boolean success = office.cancelBooking(workplace);
        assertTrue(success);
    }

    @Test
    public void when_workplace_is_reserved_it_can_not_be_canceled_twice() {
        Office office = office();

        Employee employee1 = employee1();
        Workplace workplace = availableWorkplace1();

        office.addWorkplace(workplace);
        office.book(workplace, employee1);
        office.cancelBooking(workplace);
        boolean success = office.cancelBooking(workplace);
        assertFalse(success);
    }

    @Test
    public void when_workplace_is_not_reserved_it_can_not_be_canceled() {
        Office office = office();
        Workplace workplace = availableWorkplace1();

        office.addWorkplace(workplace);
        boolean success = office.cancelBooking(workplace);
        assertFalse(success);
    }

    @Test
    public void when_employee_can_book_3_workplaces_all_bookings_are_successful() {

        Office office = office();

        Workplace workplace1 = availableWorkplace1();
        Workplace workplace2 = availableWorkplace2();
        Workplace workplace3 = availableWorkplace3();

        office.addWorkplace(workplace1);
        office.addWorkplace(workplace2);
        office.addWorkplace(workplace3);

        Employee employee = employee1();

        boolean success1 = office.book(workplace1, employee);
        boolean success2 = office.book(workplace2, employee);
        boolean success3 = office.book(workplace3, employee);

        assertTrue(success1);
        assertTrue(success2);
        assertTrue(success3);
    }

    @Test
    public void when_employee_can_book_2_workplaces_two_bookings_are_successful_and_last_is_failed() {

        Office office = office();

        Workplace workplace1 = availableWorkplace1();
        Workplace workplace2 = availableWorkplace2();
        Workplace workplace3 = availableWorkplace3();

        office.addWorkplace(workplace1);
        office.addWorkplace(workplace2);
        office.addWorkplace(workplace3);

        Employee employee = employee1();
        employee.setMaximumWorkplaces(2);

        boolean success1 = office.book(workplace1, employee);
        boolean success2 = office.book(workplace2, employee);
        boolean success3 = office.book(workplace3, employee);

        assertTrue(success1);
        assertTrue(success2);
        assertFalse(success3);
    }

    @Test
    public void test_toString_for_empty_office() {
        Office office = office();
        assertThat(office.toString(), is(OFFICE_NAME + ": 0 books; 0 people."));
    }

    @Test
    public void test_toString_for_non_empty_office() {
        Office office = office();

        Workplace workplace1 = availableWorkplace1();
        Employee employee = employee1();

        office.addWorkplace(workplace1);
        office.book(workplace1, employee);

        assertThat(office.toString(), is(OFFICE_NAME + ": 1 books; 0 people."));
    }

    private Office office() {
        return new Office(OFFICE_NAME);
    }

    private Workplace availableWorkplace1() {
        return new Workplace("ID1");
    }

    private Workplace availableWorkplace2() {
        return new Workplace("ID2");
    }

    private Workplace availableWorkplace3() {
        return new Workplace("ID3");
    }

    private Workplace takenWorkplace1() {
        Employee employee = new Employee("Vasja");
        Workplace workplace = new Workplace("ID3");
        workplace.setEmployee(employee);
        return workplace;
    }

    private Employee employee1() {
        return new Employee("Nikita");
    }

    private Employee employee2() {
        return new Employee("Vlad");
    }
}