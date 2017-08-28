/**
 * This class file was automatically generated by the AXDR compiler that is part of jDLMS (http://www.openmuc.org)
 */

package org.openmuc.jdlms.internal.asn1.cosem;

import java.io.IOException;
import java.io.InputStream;

import org.openmuc.jasn1.ber.BerByteArrayOutputStream;
import org.openmuc.jdlms.internal.asn1.axdr.AxdrType;
import org.openmuc.jdlms.internal.asn1.axdr.types.AxdrSequenceOf;

public class Get_Response_With_List implements AxdrType {

    public static class SubSeqOf_result extends AxdrSequenceOf<Get_Data_Result> {

        @Override
        protected Get_Data_Result createListElement() {
            return new Get_Data_Result();
        }

        protected SubSeqOf_result(int length) {
            super(length);
        }

        public SubSeqOf_result() {
        } // Call empty base constructor

    }

    public byte[] code = null;
    public Invoke_Id_And_Priority invoke_id_and_priority = null;

    public SubSeqOf_result result = null;

    public Get_Response_With_List() {
    }

    public Get_Response_With_List(byte[] code) {
        this.code = code;
    }

    public Get_Response_With_List(Invoke_Id_And_Priority invoke_id_and_priority, SubSeqOf_result result) {
        this.invoke_id_and_priority = invoke_id_and_priority;
        this.result = result;
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
            codeLength += result.encode(axdrOStream);

            codeLength += invoke_id_and_priority.encode(axdrOStream);

        }

        return codeLength;

    }

    @Override
    public int decode(InputStream iStream) throws IOException {
        int codeLength = 0;

        invoke_id_and_priority = new Invoke_Id_And_Priority();
        codeLength += invoke_id_and_priority.decode(iStream);

        result = new SubSeqOf_result();
        codeLength += result.decode(iStream);

        return codeLength;
    }

    public void encodeAndSave(int encodingSizeGuess) throws IOException {
        BerByteArrayOutputStream axdrOStream = new BerByteArrayOutputStream(encodingSizeGuess);
        encode(axdrOStream);
        code = axdrOStream.getArray();
    }

    @Override
    public String toString() {
        return "sequence: {" + "invoke_id_and_priority: " + invoke_id_and_priority + ", result: " + result + "}";
    }

}
