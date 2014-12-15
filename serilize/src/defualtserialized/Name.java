package defualtserialized;

// Good candidate for default serialized form
public class Name {
	/**
	 *  Last name. Must be non-null
	 *  @serial
	 */
	@SuppressWarnings("unused")
	private final String lastName = "";
	
	/**
	 * First name, Must be non-null.
	 * @serial
	 */
	@SuppressWarnings("unused")
	private final String firstName = "";
	
	/**
	 * Middle name, or null if there is none.
	 */
	@SuppressWarnings("unused")
	private final String middleName = null;
	
	// Remainder omitted
}
