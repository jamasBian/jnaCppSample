

import java.util.HashMap;
import java.util.Map;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.win32.StdCallFunctionMapper;
import com.sun.jna.win32.StdCallLibrary;

public class Demo {
	public static void main(String[] args) {
		
		System.out.println(Dll1.lib.factorial(7));
		System.out.println(Dll1.lib.add(1,3));

	}

}
