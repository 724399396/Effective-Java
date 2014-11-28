package collectionFirst;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.util.Map;
import java.util.HashMap;

// Typesafe hetergeneous container pattern - implementation
public class Favorites {
	private Map<Class<?>, Object> favorites = 
			new HashMap<Class<?>, Object>();
	// Acheving runtime type safett with a dynamic cast
	public <T> void putFavorite(Class<T> type, T instance) {
		if (type == null)
			throw new NullPointerException("Type is null");
		favorites.put(type, type.cast(instance));
	}
	public <T> T getFavorite(Class<T> type) {
		return type.cast(favorites.get(type));
	}
	
	public static void main(String[] args) {
		Favorites f = new Favorites();
		f.putFavorite(String.class, "Java");
		f.putFavorite(Integer.class, 0xcafebabe);
		f.putFavorite(Class.class, Favorites.class);
		String favoriteString = f.getFavorite(String.class);
		int favoriteInteger = f.getFavorite(Integer.class);
		Class<?> favoriteClass = f.getFavorite(Class.class);
		System.out.printf("%s %x %s%n", favoriteString,
				favoriteInteger, favoriteClass.getName());
	}
	
	//Use of asSubclass to safely cast to a bounded type token
	static Annotation getAnnotation(AnnotatedElement element,
				String annotationTypeName) {
		Class<?> annotationType = null;  // Unbounded type token
		try {
			annotationType = Class.forName(annotationTypeName);
		} catch (Exception ex) {
			throw new IllegalArgumentException(ex);
		}
		return element.getAnnotation(annotationType.asSubclass(Annotation.class));
	}
}
