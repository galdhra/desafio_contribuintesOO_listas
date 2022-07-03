package entities;

public class TaxPayer {
	private Double salaryIncome;
	private Double serviceIncome;
	private Double capitalIncome;
	private Double healthSpending;
	private Double educationSpending;

	public TaxPayer(Double salaryIncome, Double serviceIncome, Double capitalIncome, Double healthSpending,
			Double educationSpending) {
		this.salaryIncome = salaryIncome;
		this.serviceIncome = serviceIncome;
		this.capitalIncome = capitalIncome;
		this.healthSpending = healthSpending;
		this.educationSpending = educationSpending;
	}

	public TaxPayer() {

	}

	public Double getSalaryIncome() {
		return salaryIncome;
	}

	public Double getServiceIncome() {
		return serviceIncome;
	}

	public Double getCapitalIncome() {
		return capitalIncome;
	}

	public Double getHealthSpending() {
		return healthSpending;
	}

	public Double getEducationSpending() {
		return educationSpending;
	}

	public Double salaryTax() {
		double monthSalary = this.salaryIncome / 12;
		if (monthSalary < 3000.0) {
			return 0.0;
		} else if (monthSalary > 5000.0) {

			return this.salaryIncome * 0.2;
		} else {
			return this.salaryIncome * 0.1;
		}
	}

	public Double servicesTax() {
		return this.serviceIncome * 0.15;
	}

	public Double capitalTax() {
		return this.capitalIncome * 0.2;
	}

	public Double grossTax() {
		return salaryTax() + servicesTax() + capitalTax();
	}

	public Double taxRebate() {
		double min = grossTax() * 0.3;
		double totalSpending = getHealthSpending() + getEducationSpending();
		if (totalSpending < min) {
			return totalSpending;
		} else {
			return min;
		}
	}

	public Double netTax() {
		return grossTax() - taxRebate();
	}
	
	public String toString() {
		return "Imposto bruto total: "
				+ String.format("%.2f%n", grossTax())
				+ "Abatimento: "
				+ String.format("%.2f%n", taxRebate())
			    + "Imposto devido: " 
				+ String.format("%.2f%n", netTax());
	}
	
	
}
