package com.java8;

import java.awt.image.AreaAveragingScaleFilter;
import java.security.Identity;
import java.text.CollationElementIterator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8FeutureExposeController {

	public static void main(String[] args) {

		ArrayList<Employee> employeeList = new ArrayList<>();

		employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
		employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
		employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
		employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
		employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
		employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
		employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
		employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
		employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
		employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
		employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
		employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
		employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
		employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
		employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
		employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
		employeeList.add(new Employee(277, "Anuj Chettiar1", 37, "Male", "Band Development", 2015, 35700.0));
		employeeList.add(new Employee(277, "Anuj Chettiar2", 34, "Female", "Sanga Development", 6012, 55700.0));
		employeeList.add(new Employee(277, "Anuj3 Chettia3r", 33, "Male", "Sura Development", 2079, 55700.0));
		employeeList.add(new Employee(277, "Anuj5 Chettiar4", 39, "female", "Infrastructure", 2019, 55700.0));

		System.out.println(employeeList);

		Employee highestSalary = employeeList.stream().max(Comparator.comparing(Employee::getSalary)).get();

		System.out.println("highestSalary :" + highestSalary);
		List<String> emplSalary = employeeList.stream().filter(fn -> fn.getSalary() == highestSalary.getSalary())
				.map(Employee::getName).collect(Collectors.toList());

		Map<String, Double> deprtSalary = employeeList.stream().collect(
				Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));

		Employee highestSalary1 = employeeList.stream()
				.collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))).get();

		Map<Integer, ConcurrentMap<String, Long>> singleEmp = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getYearOfJoining,
						Collectors.groupingByConcurrent(Employee::getDepartment, Collectors.counting())));

		highestSalary1 = employeeList.stream().sorted(Comparator.comparing(Employee::getYearOfJoining).reversed())
				.findFirst().get();

		List<Integer> yougestEmp = employeeList.stream().filter(y -> y.getAge() <= 25).map(Employee::getAge)
				.collect(Collectors.toList());
		List<Integer> olderEmp = employeeList.stream().filter(y -> y.getAge() > 25).map(Employee::getAge)
				.collect(Collectors.toList());

		Map<Boolean, List<Employee>> map = employeeList.stream()
				.collect(Collectors.partitioningBy(youg -> youg.getAge() > 25));

		System.out.println(
				"yougestEmp :" + yougestEmp.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList()));
		System.out.println(
				"olderEmp :" + olderEmp.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList()));

		DoubleSummaryStatistics douBle = employeeList.stream()
				.collect(Collectors.summarizingDouble(Employee::getSalary));

		System.out.println("everage salary : " + douBle.getAverage());
		System.out.println("total salary : " + douBle.getSum());
		System.out.println("max salary : " + douBle.getMax());
		System.out.println("min salary : " + douBle.getMin());
		System.out.println("count salary : " + douBle.getCount());

		Map<String, List<Employee>> dataList = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment));

		for (Entry<String, List<Employee>> data : dataList.entrySet()) {
			System.out.println("---------------------------------------------------------------");
			System.out.println("Name of department ::" + data.getKey());

			for (Employee emp : data.getValue()) {

				System.out.println(emp.getName());
			}
		}
		Map<String, Double> avarageSalaryOfGender = employeeList.stream().collect(
				Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(sal -> sal.getSalary())));

		for (Entry<String, Double> key : avarageSalaryOfGender.entrySet()) {
			System.out.println("_______________________________________________________");
			System.out.println("Average Salary : " + key.getKey() + "::" + key.getValue());
			System.out.println("_______________________________________________________");
		}

		Map<String, Long> gengerDept = employeeList.stream()
				.filter(emp -> emp.getDepartment().equalsIgnoreCase("Sales And Marketing"))
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
		System.out.println(gengerDept);

		DoubleSummaryStatistics statics = employeeList.stream()
				.collect(Collectors.summarizingDouble(Employee::getSalary));

		Employee names = employeeList.stream().max(Comparator.comparing(Employee::getYearOfJoining).reversed()).get();

		names = employeeList.stream().sorted(Comparator.comparingInt(Employee::getYearOfJoining)).findFirst().get();

		System.out.println("most working experiance of employee: " + names.getName() + " and year of Joining : "
				+ names.getYearOfJoining());

		Employee yougestEmpInDepartment = employeeList.stream()
				.filter(age -> age.getGender() == "Male" && age.getDepartment() == "Product Development")
				.min(Comparator.comparingInt(Employee::getYearOfJoining)).get();

		Map<String, Double> aveargeSalaryOfEachDept = employeeList.stream().collect(
				Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));

		for (Map.Entry<String, Double> avg : aveargeSalaryOfEachDept.entrySet()) {
			System.out.println("________________________________________________________");
			System.out.println(avg.getKey() + "::" + avg.getValue());
		}

		Map<String, Long> countNumbeEmpByDeapt = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));

		for (Map.Entry<String, Long> data : countNumbeEmpByDeapt.entrySet()) {
			System.out.println("----------------------------------------------");
			System.out.println(data.getKey() + ":" + data.getValue());
			System.out.println("----------------------------------------------");
		}

		employeeList.stream().filter(yr -> yr.getYearOfJoining() > 2015).map(fn -> fn.getName())
				.forEach(System.out::println);

		Map<String, Double> avarageAge = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getAge)));

		for (Map.Entry<String, Double> avg : avarageAge.entrySet()) {
			System.out.println("----------------------------------------------");
			System.out.println(avg.getKey() + ":" + avg.getValue());
			System.out.println("----------------------------------------------");
		}

		List<String> depat = employeeList.stream().map(d -> d.getDepartment()).distinct().collect(Collectors.toList());

		depat = employeeList.stream().map(n -> n.getName()).distinct().collect(Collectors.toList());

		employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting())).entrySet()
				.forEach(System.out::println);

		Map<Double, Set<Employee>> sortedSet = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getSalary, Collectors.toSet()));
		for (Map.Entry<Double, Set<Employee>> avg : sortedSet.entrySet()) {
			System.out.println("----------------------------------------------");
			System.out.println(avg.getKey() + ":" + avg.getValue());
			System.out.println("----------------------------------------------");
		}

		// find the average age of male and female employee
		Map<String, Double> averageEmployeeAge = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)));

		System.out.println(averageEmployeeAge);

		// find highest salary in each of the depatment

		Map<String, Optional<Employee>> higestSalry = employeeList.stream().collect(Collectors
				.groupingBy(Employee::getDepartment, Collectors.maxBy(Comparator.comparing(Employee::getSalary))));
		for (Map.Entry<String, Optional<Employee>> high : higestSalry.entrySet()) {

			System.out.println("----------------------------------------------");
			System.out.println(high.getKey() + ":" + high.getValue());
			System.out.println("----------------------------------------------");
		}

		// find second highest salary fro employe table

		Employee secodnSalary = employeeList.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
				.skip(4).findFirst().get();

		System.out.println(secodnSalary.getName() + "::" + secodnSalary.getSalary());
		// find the employeees who age is betweek 25 and 35

		List<Employee> between = employeeList.stream().filter(fn -> fn.getAge() > 20 && fn.getAge() < 50)
				.collect(Collectors.toList());

		Map<Boolean, List<Employee>> betweenMap = employeeList.stream()
				.collect(Collectors.partitioningBy(age -> age.getAge() > 25, Collectors.toList()));

		// Find the employee who are in HR depart and sort them by their name

		between = employeeList.stream().filter(fn -> fn.getDepartment() == "HR")
				.sorted(Comparator.comparing(Employee::getName, Comparator.reverseOrder()))
				.collect(Collectors.toList());
		List<String> getDepartment = employeeList.stream().map(dept -> dept.getDepartment())
				.collect(Collectors.toList());
		for (String dep : getDepartment) {
			System.out.println("----------------------------------------------");
			System.out.println(dep);
		}

		Map<String, Double> averageSalry = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getSalary)));

		System.out.println(averageSalry);

		String number = "723843495835698561222";

		String[] arr = number.split("");

		int[] intArray = Arrays.stream(arr).mapToInt(Integer::parseInt).toArray();

		List numb = Arrays.asList(6, 9, 8, 5, 6, 1, 2, 2, 2);

		long freq = Collections.frequency(numb, 2);

		System.out.println(freq);

		String[] arrStr = { "Apple", "computersystem", "Orange", "banana", "computersystem" };

		String longChar = Arrays.stream(arrStr).reduce((x1, x2) -> x1.length() > x2.length() ? x1 : x2).get();

		Set<String> arrDuplicate = Arrays.stream(number.split("")).collect(Collectors.toSet());
		System.out.println(arrDuplicate);
		Set<String> singLeChar = new HashSet<String>();

		Map<Character, Long> dupliChar = number.chars().mapToObj(ch -> (char) ch)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		Map<String, Long> singLeCharList = Arrays.stream(number.split("")).filter(ch -> !singLeChar.add(ch))
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		System.out.println("Set :" + dupliChar);
		System.out.println("Array :" + singLeCharList);

		List numb1 = Arrays.asList(6, 9, 8, 5, 6, 1, 2, 2, 2);

		Collections.rotate(numb1, -19);

		numb1 = Collections.singletonList(numb1);
		// numb1.add(67);
		System.out.println(" rotate : " + numb1);

		Set<String> singLe = Collections.singleton("manjunath");
		// singLe.add("rathod");
		System.out.println("immutable object :" + singLe);

		Map<Boolean, Set<Double>> list = employeeList.stream().collect(Collectors.partitioningBy(
				pr -> pr.getSalary() > 30000, Collectors.mapping(Employee::getSalary, Collectors.toSet())));

		for (Map.Entry<Boolean, Set<Double>> entry : list.entrySet()) {

			if (entry.getKey() == false) {
				System.out.println("**********salary less than 30000**********");
				System.out.println(entry.getValue());
			} else {
				System.out.println("**********salary greater than 30000*****");
				System.out.println(entry.getValue());
			}

		}

		DoubleSummaryStatistics sumary = employeeList.stream()
				.collect(Collectors.summarizingDouble(Employee::getSalary));
		System.out.println("max salary :" + sumary.getMax());

		List<Double> maxSalarys = employeeList.stream().filter(ev -> ev.getSalary() == sumary.getMax())
				.map(y -> y.getSalary()).collect(Collectors.toList());
		System.out.println(" max salaries :" + maxSalarys);

		Map<Double, List<String>> namesSala = employeeList.stream().collect(
				Collectors.groupingBy(Employee::getSalary, Collectors.mapping(Employee::getName, Collectors.toList())));

		long name = employeeList.stream().collect(Collectors.mapping(Employee::getName, Collectors.counting()));
		System.out.println(name);

		List<String> order = Arrays.asList("circuit", "engine", "system", "computer");

		Map<String, Integer> fat = order.stream().collect(Collectors.toMap(Function.identity(), String::length));
		System.out.println(fat);

		Stream<Integer> arr1 = Stream.of(2, 3, 6, 8, 45, 3);
		Stream<Integer> arr2 = Stream.of(2, 3, 6, 8, 45, 3);

		List<Integer> twoArra = Stream.concat(arr1, arr2).collect(Collectors.toList());

		Double sala = employeeList.stream().map(Employee::getSalary).max(Comparator.naturalOrder()).get();

		Employee employeeDetails = employeeList.stream().max(Comparator.comparing(Employee::getSalary)).get();

		Map<Double, List<Employee>> group = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getSalary, Collectors.toList()));

		List<Entry<Double, List<Employee>>> data = group.entrySet().stream().sorted(Map.Entry.comparingByKey())
				.collect(Collectors.toList());

		Double maxSalSorted = employeeList.stream()
				.sorted(Comparator.comparing(Employee::getSalary, Comparator.reverseOrder())).map(e -> e.getSalary())
				.findAny().get();

		employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment,
						Collectors.summarizingDouble(Employee::getSalary)))
				.entrySet().forEach(f -> System.out.println(f));
		System.out.println("max sala:");

	}

}
