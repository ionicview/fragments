package csvdemo;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.stream.Stream;

import com.opencsv.CSVReader;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;

public class CsvSample<E> {
	public static final String CSV = ".csv";
	private Class<E> type;

	public CsvSample(Class<E> type) {
		this.type = type;
	}

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

	public BiConsumer<Path, String[]> runGenericBean() {
		return (path, columns) -> {
			try (Reader reader = Files.newBufferedReader(path, Charset.forName("UTF-8"));
					CSVReader csvReader = new CSVReader(reader, ',', '\"', 1);) {

				ColumnPositionMappingStrategy<E> strat = new ColumnPositionMappingStrategy<>();
				strat.setType(type);
				strat.setColumnMapping(columns);

				CsvToBean<E> csv = new CsvToBean<>();
				List<E> beans = csv.parse(strat, csvReader);

				beans.forEach(System.out::println);

			} catch (IOException e) {
				e.printStackTrace();
			}

		};

	}

	public Class<E> getType() {
		return type;
	}

	public void setType(Class<E> type) {
		this.type = type;
	}

}
