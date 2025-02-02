package de.pb.bv.common;

public enum DataSource implements DbEnum {
    BRICKLINK(1),
    ;

    private final int dbKey;
    DataSource(int dbKey) {
        this.dbKey = dbKey;
    }

    @Override
    public int getDbKey() {
        return dbKey;
    }
}
