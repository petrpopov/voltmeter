package com.petrpopov.voltmeter.web.other;

/**
 * User: petrpopov
 * Date: 08.01.14
 * Time: 14:49
 */
public class VoltStatDTO implements Comparable {

    private Integer state;
    private Long count;

    public VoltStatDTO() {
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    @Override
    public int compareTo(Object o) {
        if( o == null )
            return -1;

        if(!(o instanceof VoltStatDTO))
            return -1;

        VoltStatDTO compare = (VoltStatDTO) o;
        Integer compareState = compare.getState();
        if( compareState == null)
            return -1;

        if( this.state == null )
            return -1;

        if( this.state < compareState )
            return -1;
        else if( this.state >  compareState )
            return 1;
        else if( state.equals(compareState) )
            return 0;

        return -1;
    }
}
