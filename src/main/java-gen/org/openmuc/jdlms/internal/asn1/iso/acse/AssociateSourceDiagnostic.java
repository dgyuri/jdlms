/**
 * This class file was automatically generated by jASN1 v1.8.0 (http://www.openmuc.org)
 */

package org.openmuc.jdlms.internal.asn1.iso.acse;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;

import org.openmuc.jasn1.ber.BerByteArrayOutputStream;
import org.openmuc.jasn1.ber.BerLength;
import org.openmuc.jasn1.ber.BerTag;
import org.openmuc.jasn1.ber.types.BerInteger;

public class AssociateSourceDiagnostic implements Serializable {

    private static final long serialVersionUID = 1L;

    public byte[] code = null;
    private BerInteger acseServiceUser = null;
    private BerInteger acseServiceProvider = null;

    public AssociateSourceDiagnostic() {
    }

    public AssociateSourceDiagnostic(byte[] code) {
        this.code = code;
    }

    public void setAcseServiceUser(BerInteger acseServiceUser) {
        this.acseServiceUser = acseServiceUser;
    }

    public BerInteger getAcseServiceUser() {
        return acseServiceUser;
    }

    public void setAcseServiceProvider(BerInteger acseServiceProvider) {
        this.acseServiceProvider = acseServiceProvider;
    }

    public BerInteger getAcseServiceProvider() {
        return acseServiceProvider;
    }

    public int encode(BerByteArrayOutputStream os) throws IOException {

        if (code != null) {
            for (int i = code.length - 1; i >= 0; i--) {
                os.write(code[i]);
            }
            return code.length;
        }

        int codeLength = 0;
        int sublength;

        if (acseServiceProvider != null) {
            sublength = acseServiceProvider.encode(os, true);
            codeLength += sublength;
            codeLength += BerLength.encodeLength(os, sublength);
            // write tag: CONTEXT_CLASS, CONSTRUCTED, 2
            os.write(0xA2);
            codeLength += 1;
            return codeLength;
        }

        if (acseServiceUser != null) {
            sublength = acseServiceUser.encode(os, true);
            codeLength += sublength;
            codeLength += BerLength.encodeLength(os, sublength);
            // write tag: CONTEXT_CLASS, CONSTRUCTED, 1
            os.write(0xA1);
            codeLength += 1;
            return codeLength;
        }

        throw new IOException("Error encoding CHOICE: No element of CHOICE was selected.");
    }

    public int decode(InputStream is) throws IOException {
        return decode(is, null);
    }

    public int decode(InputStream is, BerTag berTag) throws IOException {

        int codeLength = 0;
        BerTag passedTag = berTag;

        if (berTag == null) {
            berTag = new BerTag();
            codeLength += berTag.decode(is);
        }

        if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 1)) {
            codeLength += BerLength.skip(is);
            acseServiceUser = new BerInteger();
            codeLength += acseServiceUser.decode(is, true);
            return codeLength;
        }

        if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 2)) {
            codeLength += BerLength.skip(is);
            acseServiceProvider = new BerInteger();
            codeLength += acseServiceProvider.decode(is, true);
            return codeLength;
        }

        if (passedTag != null) {
            return 0;
        }

        throw new IOException("Error decoding CHOICE: Tag " + berTag + " matched to no item.");
    }

    public void encodeAndSave(int encodingSizeGuess) throws IOException {
        BerByteArrayOutputStream os = new BerByteArrayOutputStream(encodingSizeGuess);
        encode(os);
        code = os.getArray();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        appendAsString(sb, 0);
        return sb.toString();
    }

    public void appendAsString(StringBuilder sb, int indentLevel) {

        if (acseServiceUser != null) {
            sb.append("acseServiceUser: ").append(acseServiceUser);
            return;
        }

        if (acseServiceProvider != null) {
            sb.append("acseServiceProvider: ").append(acseServiceProvider);
            return;
        }

        sb.append("<none>");
    }

}
