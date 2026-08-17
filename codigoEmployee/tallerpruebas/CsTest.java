package tallerpruebas;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class CsTest {

    private Employee Trabajador1;
    private Employee Trabajador2;
    private Employee Trabajador3;
    private Employee Manager1;
    private Employee Supervisor1;
    private Employee Supervisor2;

    @BeforeEach
    void inicializarEmpleados() {
        Trabajador1 = new Employee(1200, "USD", 5, EmployeeType.Worker);
        Trabajador2 = new Employee(1000, "EUR", 7, EmployeeType.Worker);
        Trabajador3 = new Employee(-500, "USD", 10, EmployeeType.Worker);
        Manager1 = new Employee(2000, "USD", 15, EmployeeType.Manager);
        Supervisor1 = new Employee(1500, "USD", 10, EmployeeType.Supervisor);
        Supervisor2 = new Employee(1800, "CAD", 12, EmployeeType.Supervisor);
    }

    private boolean esMesImpar() {
        // Determina si el mes actual es impar
        int mesActual = LocalDate.now().getMonthValue();
        return mesActual % 2 != 0;
    }

    @Test
    void salarioMesUSDTest() {
        if (esMesImpar()) {
            // Mes impar
            float salarioEsperadoTrabajador1 = 386.0f / 6 + 1200;
            float salarioEsperadoSupervisor1 = 386.0f / 6 + 1500 + (10 * 0.35f);
            float salarioEsperadoManager1 = 386.0f / 6 + 2000 + (15 * 0.7f);

            assertEquals(salarioEsperadoTrabajador1, Trabajador1.cs(), "Salario mes impar trabajador 1 incorrecto");
            assertEquals(salarioEsperadoSupervisor1, Supervisor1.cs(), "Salario mes impar supervisor 1 incorrecto");
            assertEquals(salarioEsperadoManager1, Manager1.cs(), "Salario mes impar manager 1 incorrecto");
        } else {
            // Mes par
            assertEquals(1200, Trabajador1.cs(), "Salario mes par trabajador 1 incorrecto");
            assertEquals(1500 + (10 * 0.35f), Supervisor1.cs(), "Salario mes par supervisor 1 incorrecto");
            assertEquals(2000 + (15 * 0.7f), Manager1.cs(), "Salario mes par manager 1 incorrecto");
        }
    }

    @Test
    void salarioMesNoUSDTest() {
        if (esMesImpar()) {
            // Mes impar
            float salarioEsperadoTrabajador2 = (1000 * 0.95f) + (386.0f / 6);
            float salarioEsperadoSupervisor2 = (1800 * 0.95f) + (12 * 0.35f) + (386.0f / 6);

            assertEquals(salarioEsperadoTrabajador2, Trabajador2.cs(), "Salario mes impar trabajador 2 incorrecto");
            assertEquals(salarioEsperadoSupervisor2, Supervisor2.cs(), "Salario mes impar supervisor 2 incorrecto");
        } else {
            // Mes par
            float salarioEsperadoTrabajador2 = 1000 * 0.95f;
            float salarioEsperadoSupervisor2 = (1800 * 0.95f) + (12 * 0.35f);

            assertEquals(salarioEsperadoTrabajador2, Trabajador2.cs(), "Salario mes par trabajador 2 incorrecto");
            assertEquals(salarioEsperadoSupervisor2, Supervisor2.cs(), "Salario mes par supervisor 2 incorrecto");
        }
    }

    @Test
    @Disabled
    void salarioConSueldoNegativoTest() {
        assertEquals(0.0f, Trabajador3.cs(), "El salario debería ser 0 para sueldos negativos");
    }
}