package com.petrpopov.voltmeter.model;


/**
 * Created by petrpopov on 07.01.14.
 */
public enum VoltState {
    zaebis(0),
    nishtyak(1),
    chotko(2),
    chetenko(3),
    rovno(4),
    herovato(5),
    pizdec(6),
    pizdec2(7),
    pp(8);

    private final int val;
    private VoltState(int state) {
        this.val = state;
    }

    public int getVal() {
        return val;
    }
}
