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
import org.openmuc.jdlms.internal.asn1.axdr.types.AxdrGeneralizedTime;
import org.openmuc.jdlms.internal.asn1.axdr.types.AxdrOptional;
import org.openmuc.jdlms.internal.asn1.axdr.types.AxdrSequenceOf;

public class InformationReportRequest implements AxdrType {

    public static class SubSeqOf_variable_access_specification extends AxdrSequenceOf<Variable_Access_Specification> {

        @Override
        protected Variable_Access_Specification createListElement() {
            return new Variable_Access_Specification();
        }

        protected SubSeqOf_variable_access_specification(int length) {
            super(length);
        }

        public SubSeqOf_variable_access_specification() {
        } // Call empty base constructor

    }

    public static class SubSeqOf_list_of_data extends AxdrSequenceOf<Data> {

        @Override
        protected Data createListElement() {
            return new Data();
        }

        protected SubSeqOf_list_of_data(int length) {
            super(length);
        }

        public SubSeqOf_list_of_data() {
        } // Call empty base constructor

    }

    public byte[] code = null;
    public AxdrOptional<AxdrGeneralizedTime> current_time = new AxdrOptional<>(new AxdrGeneralizedTime(), false);

    public SubSeqOf_variable_access_specification variable_access_specification = null;

    public SubSeqOf_list_of_data list_of_data = null;

    public InformationReportRequest() {
    }

    public InformationReportRequest(byte[] code) {
        this.code = code;
    }

    public InformationReportRequest(AxdrGeneralizedTime current_time,
            SubSeqOf_variable_access_specification variable_access_specification, SubSeqOf_list_of_data list_of_data) {
        this.current_time.setValue(current_time);
        this.variable_access_specification = variable_access_specification;
        this.list_of_data = list_of_data;
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
            codeLength += list_of_data.encode(axdrOStream);

            codeLength += variable_access_specification.encode(axdrOStream);

            codeLength += current_time.encode(axdrOStream);

        }

        return codeLength;

    }

    @Override
    public int decode(InputStream iStream) throws IOException {
        int codeLength = 0;

        current_time = new AxdrOptional<>(new AxdrGeneralizedTime(), false);
        codeLength += current_time.decode(iStream);

        variable_access_specification = new SubSeqOf_variable_access_specification();
        codeLength += variable_access_specification.decode(iStream);

        list_of_data = new SubSeqOf_list_of_data();
        codeLength += list_of_data.decode(iStream);

        return codeLength;
    }

    public void encodeAndSave(int encodingSizeGuess) throws IOException {
        BerByteArrayOutputStream axdrOStream = new BerByteArrayOutputStream(encodingSizeGuess);
        encode(axdrOStream);
        code = axdrOStream.getArray();
    }

    @Override
    public String toString() {
        return "sequence: {" + "current_time: " + current_time + ", variable_access_specification: "
                + variable_access_specification + ", list_of_data: " + list_of_data + "}";
    }

}
