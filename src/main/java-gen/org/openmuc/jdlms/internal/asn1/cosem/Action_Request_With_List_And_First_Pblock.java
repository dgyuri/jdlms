/**
 * Copyright 2012-17 Fraunhofer ISE
 *
 * This file is part of jDLMS.
 * For more information visit http://www.openmuc.org
 *
 * jDLMS is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * jDLMS is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with jDLMS.  If not, see <http://www.gnu.org/licenses/>.
 */
/**
 * This class file was automatically generated by the AXDR compiler that is part of jDLMS (http://www.openmuc.org)
 */

package org.openmuc.jdlms.internal.asn1.cosem;

import java.io.IOException;
import java.io.InputStream;

import org.openmuc.jasn1.ber.BerByteArrayOutputStream;
import org.openmuc.jdlms.internal.asn1.axdr.AxdrType;
import org.openmuc.jdlms.internal.asn1.axdr.types.AxdrSequenceOf;

public class Action_Request_With_List_And_First_Pblock implements AxdrType {

    public static class SubSeqOf_cosem_method_descriptor_list extends AxdrSequenceOf<Cosem_Method_Descriptor> {

        @Override
        protected Cosem_Method_Descriptor createListElement() {
            return new Cosem_Method_Descriptor();
        }

        protected SubSeqOf_cosem_method_descriptor_list(int length) {
            super(length);
        }

        public SubSeqOf_cosem_method_descriptor_list() {
        } // Call empty base constructor

    }

    public byte[] code = null;
    public Invoke_Id_And_Priority invoke_id_and_priority = null;

    public SubSeqOf_cosem_method_descriptor_list cosem_method_descriptor_list = null;

    public DataBlock_SA pblock = null;

    public Action_Request_With_List_And_First_Pblock() {
    }

    public Action_Request_With_List_And_First_Pblock(byte[] code) {
        this.code = code;
    }

    public Action_Request_With_List_And_First_Pblock(Invoke_Id_And_Priority invoke_id_and_priority,
            SubSeqOf_cosem_method_descriptor_list cosem_method_descriptor_list, DataBlock_SA pblock) {
        this.invoke_id_and_priority = invoke_id_and_priority;
        this.cosem_method_descriptor_list = cosem_method_descriptor_list;
        this.pblock = pblock;
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
            codeLength += pblock.encode(axdrOStream);

            codeLength += cosem_method_descriptor_list.encode(axdrOStream);

            codeLength += invoke_id_and_priority.encode(axdrOStream);

        }

        return codeLength;

    }

    @Override
    public int decode(InputStream iStream) throws IOException {
        int codeLength = 0;

        invoke_id_and_priority = new Invoke_Id_And_Priority();
        codeLength += invoke_id_and_priority.decode(iStream);

        cosem_method_descriptor_list = new SubSeqOf_cosem_method_descriptor_list();
        codeLength += cosem_method_descriptor_list.decode(iStream);

        pblock = new DataBlock_SA();
        codeLength += pblock.decode(iStream);

        return codeLength;
    }

    public void encodeAndSave(int encodingSizeGuess) throws IOException {
        BerByteArrayOutputStream axdrOStream = new BerByteArrayOutputStream(encodingSizeGuess);
        encode(axdrOStream);
        code = axdrOStream.getArray();
    }

    @Override
    public String toString() {
        return "sequence: {" + "invoke_id_and_priority: " + invoke_id_and_priority + ", cosem_method_descriptor_list: "
                + cosem_method_descriptor_list + ", pblock: " + pblock + "}";
    }

}
