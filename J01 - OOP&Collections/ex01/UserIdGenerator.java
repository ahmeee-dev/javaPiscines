public class UserIdGenerator {
	
	private int userCount = 0;
	private static final UserIdGenerator INSTANCE = new UserIdGenerator();
	private UserIdGenerator() {}; 
	public static UserIdGenerator getIntance () { return INSTANCE; };
	public int generateId() { return ++userCount; };
}