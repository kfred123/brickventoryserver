package de.pb.bv.common;

public interface DbEnum {
    int getDbKey();

    static <T extends Enum<T> & DbEnum> T fromDbKey(Class<T> enumClass, int dbKey) {
        for (T value : enumClass.getEnumConstants()) {
            if (value.getDbKey() == dbKey) {
                return value;
            }
        }
        throw new IllegalArgumentException("No enum constant with dbKey " + dbKey);
    }
}
