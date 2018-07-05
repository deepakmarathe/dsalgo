package com.deepakm.effectivejava;

public final class PhoneNumber implements Cloneable, Comparable<PhoneNumber> {
    private final short areaCode;
    private final short prefix;
    private final short lineNumber;

    public PhoneNumber(int areaCode, int prefix, int lineNumber) {
        rangeCheck(areaCode, 999, "area code");
        rangeCheck(prefix, 999, "prefix");
        rangeCheck(lineNumber, 9999, "line number");
        this.areaCode = (short) areaCode;
        this.prefix = (short) prefix;
        this.lineNumber = (short) lineNumber;
    }

    private static void rangeCheck(int arg, int max, String name) {
        if (arg < 0 || arg > max) throw new IllegalArgumentException(name + " : " + arg);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof PhoneNumber)) return false;
        PhoneNumber other = (PhoneNumber) o;
        return other.lineNumber == this.lineNumber
                && other.prefix == this.prefix
                && other.areaCode == this.areaCode;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + areaCode;
        result = 31 * result + prefix;
        result = 31 * result + lineNumber;
        return result;
    }

    @Override
    public PhoneNumber clone(){
        try{
            return (PhoneNumber) super.clone();
        }catch(CloneNotSupportedException e){
            throw new AssertionError();
        }
    }

    @Override
    public String toString(){
        return areaCode + ", " + prefix + ", " + lineNumber;
    }

    @Override
    public int compareTo(PhoneNumber o) {
        // Compare area codes.
        int areaCodeDiff = areaCode - o.areaCode;
        if( areaCodeDiff != 0) return areaCodeDiff;

        // Area codes are equal, compare prefixes.
        int prefixDiff = prefix - o.prefix;
        if( prefixDiff != 0) return prefixDiff;

        // Area codes and prefixes are equal, compare line numbers.
        return lineNumber - o.lineNumber;
    }

    public static void main(String[] args) {
        PhoneNumber phoneNumber = new PhoneNumber(1, 1, 1);
        System.out.println(phoneNumber);
        PhoneNumber clone = phoneNumber.clone();
        System.out.println(clone);
    }
}
