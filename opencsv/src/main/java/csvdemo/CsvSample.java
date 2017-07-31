package csvdemo;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Stream;

import com.opencsv.CSVReader;

public class CsvSample<E> {
	public static final String CSV = ".csv";

	public Consumer<Path> runGeneric() {
		return (path) -> {

			try (Reader reader = Files.newBufferedReader(path, Charset.forName("UTF-8"));
					CSVReader csvReader = new CSVReader(reader, ',', '\"', 1);) {

				StringBuffer sb = new StringBuffer();
				csvReader.forEach((strs) -> {
					Stream.of(strs).filter(Objects::nonNull).forEach((str) -> {

						sb.append(str).append("\t");
					});
					sb.append("\n");
				});
				System.out.println(sb);

			} catch (IOException e) {
				e.printStackTrace();
			}

		};

	}

}
