package tutorial.model;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class EmployeeTest {

    @Test
    public void when_setName_is_invoked_with_value_that_value_is_returned_by_getName() throws Exception {
        String value = "vasja";
        Employee employee = new Employee();
        employee.setName(value);
        assertThat(employee.getName(), is(value));
    }

    @Test
    public void when_setName_is_not_invoked_getName_should_retunr_unknown() throws Exception {
        Employee employee = new Employee();
        assertThat(employee.getName(), is("unknown name"));
    }

    @Test
    public void when_setMaximumWorkingPlaces_is_invoked_with_value_that_value_is_returned_by_getMaximumWorkplaces() {
        int value = 5;
        Employee employee = new Employee();
        employee.setMaximumWorkplaces(value);
        assertThat(employee.getMaximumWorkplaces(), is(value));
    }

    @Test
    public void when_setMaximumWorkingPlaces_is_not_invoked_getMaximumWorkplaces_should_return_3() {
        Employee employee = new Employee();
        assertThat(employee.getMaximumWorkplaces(), is(3));
    }

    @Test
    public void when_employee_with_set_name_and_max_workplaces_is_casted_toString_the_correct_string_value_is_returned() {
        String name = "vasja";
        int maxWorkplaces = 10;
        Employee employee = new Employee(name);
        employee.setMaximumWorkplaces(maxWorkplaces);

        assertThat(employee.toString(), is(name + ", max: " + maxWorkplaces));
    }

    @Test
    public void when_employee_is_casted_toString_the_correct_string_value_is_returned() {
        Employee employee = new Employee();
        assertThat(employee.toString(), is("unknown name, max: 3"));
    }

}