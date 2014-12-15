/**
 * Created by Strashimir on 15.12.2014 г..
 */
package com.mentormate.academy.redoflags;

public enum Countries {
    Albania("ALB", R.drawable.albania),
    Austria("AUS", R.drawable.austria),
    Azerbaijan("AZB", R.drawable.azerbaijan),
    Belarus("BLU", R.drawable.belarus),
    Belgium("BLG", R.drawable.belgium),
    Bosnia("BOS", R.drawable.bosnia),
    Bulgaria("BUL", R.drawable.bulgaria),
    Croatia("CRT", R.drawable.croatia),
    Cyprus("CRP", R.drawable.cyprus),
    Czech("CZH", R.drawable.czech),
    Denmark("DNM", R.drawable.denmark),
    Estonia("EST", R.drawable.estonia),
    Finland("FIN", R.drawable.finland),
    France("FR", R.drawable.france),
    Georgia("GRG", R.drawable.georgia),
    Germany("DE", R.drawable.germany),
    Greece("GR", R.drawable.greece),
    Hungary("HUN", R.drawable.hungary),
    Iceland("ICE", R.drawable.iceland),
    Ireland("IRE", R.drawable.ireland),
    Italy("ITA", R.drawable.italy),
    Latvia("LTV", R.drawable.latvia),
    Liechtenstein("LCH", R.drawable.liechtenstein),
    Lithuania("LTH", R.drawable.lithuania),
    Luxembourg("LMB", R.drawable.luxembourg),
    Macedonia("MCD", R.drawable.macedonia),
    Malta("MLT", R.drawable.malta),
    Moldova("MLD", R.drawable.moldova),
    Monaco("MNC", R.drawable.monaco),
    Montenegro("MNG", R.drawable.montenegro),
    Netherlands("NTL", R.drawable.netherlands),
    Norway("NRW", R.drawable.norway),
    Poland("PLD", R.drawable.poland),
    Portugal("PGL", R.drawable.portugal),
    Romania("RMN", R.drawable.romania),
    Russia("RUS", R.drawable.russia),
    San_Marino("SNM", R.drawable.sanmarino),
    Serbia("SRB", R.drawable.serbia),
    Slovakia("SLK", R.drawable.slovakia),
    Slovenia("SLV", R.drawable.slovenia),
    Spain("SPN", R.drawable.spain),
    Sweden("SWD", R.drawable.sweden),
    Switzerland("SWZ", R.drawable.switzerland),
    Turkey("TRK", R.drawable.turkey),
    United_Kingdom("UK", R.drawable.uk),
    Ukraine("UKR", R.drawable.ukraine),
    Vatican("VTC", R.drawable.vatican);
    private final String code;
    private final int flag;

    Countries(String code, int flag) {
        this.code = code;
        this.flag = flag;
    }

    public String code() {
        return code;
    }

    public int flag() {
        return flag;
    }
    //fix uk and san marino
}
