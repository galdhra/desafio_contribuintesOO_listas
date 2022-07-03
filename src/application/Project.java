package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.TaxPayer;

public class Project {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("Quantos contribuintes você vai digitar? ");
		int n = sc.nextInt();

		List<TaxPayer> list = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			System.out.println();
			System.out.println("Digite os dados do " + (i + 1) + "o contribuinte:");
			System.out.print("Renda anual com salário: ");
			sc.nextLine();
			double salaryIncome = sc.nextDouble();
			System.out.print("Renda anual com prestação de serviço: ");
			double serviceIncome = sc.nextDouble();
			System.out.print("Renda anual com ganho de capital: ");
			double capitalIncome = sc.nextDouble();
			System.out.print("Gastos médicos: ");
			double healthSpending = sc.nextDouble();
			System.out.print("Gastos médicos: ");
			double educationSpending = sc.nextDouble();
			list.add(new TaxPayer(salaryIncome, serviceIncome, capitalIncome, healthSpending, educationSpending));
		}
		
		
		for(Object obj : list) {
			System.out.println();
			System.out.println("Resumo do "+ (list.indexOf(obj) + 1) + "o contribuinte:");
			System.out.println(obj);
		}

		sc.close();

	}

}
