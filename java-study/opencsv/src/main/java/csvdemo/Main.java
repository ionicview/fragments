package csvdemo;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

	private static final String rootCsvPathNm = "src/main/java/csv";

	public static void main(String[] args) {

		Path path = Paths.get(rootCsvPathNm, "generic" + CsvSample.CSV);

		CsvSample<Person> csvSample = new CsvSample<>(Person.class);

		// generic
		csvSample.runGeneric().accept(path);

		// generic bean
		csvSample.runGenericBean().accept(path, new String[] { "name", "age", "sex" });

	}

}
