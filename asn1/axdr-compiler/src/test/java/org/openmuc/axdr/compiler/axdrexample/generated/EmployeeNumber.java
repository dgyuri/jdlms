/**
 * This class file was automatically generated by the AXDR compiler that is part of jDLMS (http://www.openmuc.org)
 */

package org.openmuc.axdr.compiler.axdrexample.generated;

import java.io.IOException;
import java.io.InputStream;
import org.openmuc.jdlms.internal.asn1.axdr.types.AxdrInteger;
import org.openmuc.jasn1.ber.BerByteArrayOutputStream;
import org.openmuc.jdlms.internal.asn1.axdr.*;
import org.openmuc.jdlms.internal.asn1.axdr.types.*;

public class EmployeeNumber extends AxdrInteger {

	public EmployeeNumber() {
		super();
	}

	public EmployeeNumber(byte[] code) {
		super();
		this.code = code;
	}

	public EmployeeNumber(long val) {
		super(val);
	}

}

