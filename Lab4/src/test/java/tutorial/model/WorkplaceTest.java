package tutorial.model;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class WorkplaceTest {

    public static final String ID = "123";

    @Test
    public void when_workplace_is_given_id_make_sure_that_it_getId_returns_that_id() {
         Workplace workplace = new Workplace(ID);
         assertThat(workplace.getId(), is(ID));
    }

    @Test
    public void when_workplace_is_given_id_make_sure_that_it_is_not_taken_by_employee() {
        Workplace workplace = new Workplace(ID);
        assertNull(workplace.getEmployee());
    }

    @Test
    public void when_workplace_is_taken_by_employee_should_return_that_employee() throws Exception {

        Employee employee = employee();

        Workplace workplace = new Workplace(ID);
        workplace.setEmployee(employee());

        assertTrue(workplace.getEmployee().getName().equals(employee.getName()));
    }

    @Test
    public void when_workplace_is_not_taken_toString_should_return_that_it_is_available() {
        Workplace workplace = new Workplace(ID);
        assertThat(workplace.toString(), is("Workplace # "+ ID +" (available)"));
    }

    @Test
    public void when_workplace_is_not_taken_toString_should_return_that_it_is_taken() {
        Employee employee = employee();
        Workplace workplace = new Workplace(ID);
        workplace.setEmployee(employee);
        assertThat(workplace.toString(), is("Workplace # "+ ID +" (booked by "+ employee.getName() +")"));
    }


    private Employee employee() {
        return new Employee("vasja");
    }
}