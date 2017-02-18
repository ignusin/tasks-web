package iglabs.tasks.utils;

import java.util.ArrayList;
import java.util.List;

import org.dozer.Mapper;

public class MapperUtils {
	public static <T, U> List<U> mapList(Mapper mapper, List<T> source, Class<U> destClass) {
		if (source == null) {
			return null;
		}
		
		ArrayList<U> result = new ArrayList<>();
		for (T item: source) {
			result.add(mapper.map(item, destClass));
		}
		
		return result;
	}
}
