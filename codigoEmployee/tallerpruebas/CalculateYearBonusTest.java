package tallerpruebas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;


class CalculateYearBonusTest {
	Employee Trabajador1, Trabajador2, Trabajador3, Manager1, Supervisor1, Supervisor2; 

	@BeforeEach
	void llenarEmpleados() {
		Trabajador1 = new Employee(1000, "USD", 5, EmployeeType.Worker);
		Trabajador2 = new Employee(980, "EUR", 5, EmployeeType.Worker);
		Trabajador3 = new Employee(-386.0f, "USD", 5, EmployeeType.Worker);
		Manager1 = new Employee(3600, "USD", 15, EmployeeType.Manager);
		Supervisor1 = new Employee(1950, "USD", 8, EmployeeType.Supervisor);
		Supervisor2 = new Employee(2000, "CAD", 8, EmployeeType.Supervisor);
	}
	@Test
	void NormalWorkersTest() {
		assertEquals(386.0f, Trabajador1.CalculateYearBonus(),"Empleado comun");
		assertEquals(3986.0f, Manager1.CalculateYearBonus(),"Manager");
		assertEquals(2143f, Supervisor1.CalculateYearBonus(),"Supervisor normal");
	}
	@Test
	void NoUSDTest() {
		assertEquals(386.0f, Trabajador2.CalculateYearBonus(),"Empleado pagado en Euros");
		assertEquals(2093f, Supervisor2.CalculateYearBonus(),"Supervisor pagado en dolares canadienses");		
	}
	@Test
	@Disabled
	void EmpleadoSueldoNegativoTest() {
		assertEquals(386.0f, Trabajador3.CalculateYearBonus(),"Supervisor pagado en deuda");
	}

}
