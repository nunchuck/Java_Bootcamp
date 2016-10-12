package Day2.EmployeeProgramme.Processor;

import Day2.EmployeeProgramme.Models.Employee;

import java.time.LocalDate;
import java.util.List;

import static Day2.EmployeeProgramme.Models.GenerateEmployee.employees;

/**
 * Created by nicholas.ball on 11/10/2016.
 */
public class TaskProcessing {
    public static void listAll() {
        for (Employee e : employees)
            System.out.println(e);
    }


    public static String SearchByFirstName(String fn) {
        String result = "";
        for (int i = 0; i < employees.size(); i++) {
            //comparator
            if (employees.get(i).getFirstName().equalsIgnoreCase(fn))
                result += String.format("[%s] %s", i, employees.get(i).toString()
                        + "\n");

            if (!result.equals("")) {
                return result;

            }
        }
        return "Not Found!";

    }

    public static String createNew(List<String> data) {
        String[] dob = data.get(3).split("/");
        String[] hd = data.get(4).split("/");
        Employee temp = new Employee(
            Integer.parseInt(data.get(0)),
            data.get(1),
            data.get(2),
            LocalDate.of(Integer.parseInt(dob[0]),
                    Integer.parseInt(dob[1]),
                    Integer.parseInt(dob[2])),
                    LocalDate.of(Integer.parseInt(hd[0]),
                            Integer.parseInt(hd[1]),
                            Integer.parseInt(hd[2])),
                            data.get(5));


        employees.add(temp);
        return "SUCCESS";
    }

}
