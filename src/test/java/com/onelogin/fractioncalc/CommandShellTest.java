package com.onelogin.fractioncalc;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.onelogin.fractioncalc.CommandShell.ScannerWrapper;

//This represents end to end in this case.
public class CommandShellTest {
	
	
	@Test
    public void testHandle() {
		ScannerWrapper mockScanner = Mockito.mock(ScannerWrapper.class);
		
		when(mockScanner.hasNextLine()).thenReturn(true);
		when(mockScanner.nextLine()).thenReturn("quit");
		
		new CommandShell(mockScanner).run();
		
		verify(mockScanner,times(1)).hasNextLine();
		verify(mockScanner,times(1)).nextLine();
	}
	
	
	

}
