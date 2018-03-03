
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import com.sun.jna.FunctionMapper;
import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;
import com.sun.jna.win32.StdCallFunctionMapper;
import com.sun.jna.win32.StdCallLibrary;

public interface Dll1 extends StdCallLibrary {
	public static class Dll1Mapper implements FunctionMapper{
		Map<String, Object> options; 
		HashMap<String, String> map;
		private static Dll1Mapper instance;
		public static Dll1Mapper i() {
			if(instance==null) {
				instance = new Dll1Mapper();
				
			}
			return instance;
		}
		private Dll1Mapper()
		{
			options = new HashMap<>();
			options.put(Library.OPTION_FUNCTION_MAPPER, this);
			map = new HashMap<>();
			map.put("add", "?add@@YAHHH@Z");
			map.put("factorial", "?factorial@@YAHH@Z");
		};
		
		@Override
		public String getFunctionName(NativeLibrary lib, Method method) {
			return map.get(method.getName());
		}
		
	}
	static Dll1 lib = (Dll1) Native.loadLibrary ("Dll1", Dll1.class, Dll1Mapper.i().options);
    public int factorial(int n);
    public int add(int a, int b);
}
