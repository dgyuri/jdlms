/**
 * This class file was automatically generated by the AXDR compiler that is part of jDLMS (http://www.openmuc.org)
 */

package org.openmuc.jdlms.internal.asn1.cosem;

import java.io.IOException;
import java.io.InputStream;

import org.openmuc.jasn1.ber.BerByteArrayOutputStream;
import org.openmuc.jdlms.internal.asn1.axdr.AxdrType;

public class Set_Request_With_Datablock implements AxdrType {

    public byte[] code = null;
    public Invoke_Id_And_Priority invoke_id_and_priority = null;

    public DataBlock_SA datablock = null;

    public Set_Request_With_Datablock() {
    }

    public Set_Request_With_Datablock(byte[] code) {
        this.code = code;
    }

    public Set_Request_With_Datablock(Invoke_Id_And_Priority invoke_id_and_priority, DataBlock_SA datablock) {
        this.invoke_id_and_priority = invoke_id_and_priority;
        this.datablock = datablock;
    }

    @Override
    public int encode(BerByteArrayOutputStream axdrOStream) throws IOException {

        int codeLength;

        if (code != null) {
            codeLength = code.length;
            for (int i = code.length - 1; i >= 0; i--) {
                axdrOStream.write(code[i]);
            }
        }
        else {
            codeLength = 0;
            codeLength += datablock.encode(axdrOStream);

            codeLength += invoke_id_and_priority.encode(axdrOStream);

        }

        return codeLength;

    }

    @Override
    public int decode(InputStream iStream) throws IOException {
        int codeLength = 0;

        invoke_id_and_priority = new Invoke_Id_And_Priority();
        codeLength += invoke_id_and_priority.decode(iStream);

        datablock = new DataBlock_SA();
        codeLength += datablock.decode(iStream);

        return codeLength;
    }

    public void encodeAndSave(int encodingSizeGuess) throws IOException {
        BerByteArrayOutputStream axdrOStream = new BerByteArrayOutputStream(encodingSizeGuess);
        encode(axdrOStream);
        code = axdrOStream.getArray();
    }

    @Override
    public String toString() {
        return "sequence: {" + "invoke_id_and_priority: " + invoke_id_and_priority + ", datablock: " + datablock + "}";
    }

}
