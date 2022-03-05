import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.stream.*;
import java.util.Arrays;

// TODO: Replace examples and use TDD development by writing your own tests

public class SolutionTest {

    @Test
    public void sampleTests() {
        assertEquals(Arrays.asList("e", "d", "a"),    TopWords.top3("a a a  b  c c  d d d d  e e e e e"));
        assertEquals(Arrays.asList("e", "ddd", "aa"), TopWords.top3("e e e e DDD ddd DdD: ddd ddd aa aA Aa, bb cc cC e e e"));
        assertEquals(Arrays.asList("won't", "wont"),  TopWords.top3("  //wont won't won't "));
        assertEquals(Arrays.asList("e"),              TopWords.top3("  , e   .. "));
        assertEquals(Arrays.asList(),                 TopWords.top3("  ...  "));
        assertEquals(Arrays.asList(),                 TopWords.top3("  '  "));
        assertEquals(Arrays.asList(),                 TopWords.top3("  '''  "));
        assertEquals(Arrays.asList(),                 TopWords.top3("OSDjqIBs pBvJGl:VzLdt-miMkl!jxbthEhtV pBvJGl uqwehNO-OuY!XvSFkFRPX-uqwehNO_pBvJGl.jxbthEhtV:OkGEpb:uqwehNO VzLdt_nG'eV/uqwehNO VzLdt miMkl aQcddO OSDjqIBs;OSDjqIBs RxKrH nG'eV uqwehNO,miMkl_OSDjqIBs.OuY aQcddO!VzLdt OSDjqIBs/miMkl!aQcddO OkGEpb OSDjqIBs OSDjqIBs VzLdt_nG'eV miMkl aQcddO_yxHqVw aQcddO VzLdt/pBvJGl pBvJGl fJGnPCwxdv uqwehNO;VzLdt miMkl OSDjqIBs VzLdt OkGEpb!aQcddO?nG'eV aQcddO VzLdt pBvJGl OSDjqIBs fJGnPCwxdv,yxHqVw miMkl pBvJGl OuY/yxHqVw/miMkl miMkl nG'eV:yxHqVw yxHqVw OuY miMkl fJGnPCwxdv VzLdt-OSDjqIBs aQcddO VzLdt jxbthEhtV;nG'eV OuY!OuY VzLdt uqwehNO:VzLdt fJGnPCwxdv!VzLdt nG'eV nG'eV:VzLdt miMkl OuY aQcddO?miMkl aQcddO_miMkl aQcddO,miMkl yxHqVw OkGEpb jxbthEhtV VzLdt!OuY!VzLdt OuY,OSDjqIBs,miMkl OuY:OSDjqIBs_RxKrH_pBvJGl yxHqVw VzLdt?pBvJGl OSDjqIBs OSDjqIBs RxKrH pBvJGl/RxKrH.uqwehNO:OSDjqIBs aQcddO fJGnPCwxdv VzLdt,jxbthEhtV OuY aQcddO;fJGnPCwxdv!aQcddO/pBvJGl-fJGnPCwxdv miMkl_miMkl,miMkl-miMkl,OSDjqIBs yxHqVw OkGEpb aQcddO pBvJGl;RxKrH/jxbthEhtV pBvJGl yxHqVw pBvJGl_aQcddO;VzLdt:pBvJGl_aQcddO pBvJGl OkGEpb pBvJGl jxbthEhtV.miMkl/OuY OuY:fJGnPCwxdv!pBvJGl OuY!nG'eV miMkl-VzLdt yxHqVw,pBvJGl/VzLdt fJGnPCwxdv uqwehNO fJGnPCwxdv pBvJGl VzLdt.pBvJGl pBvJGl uqwehNO?nG'eV miMkl VzLdt,miMkl nG'eV?yxHqVw OuY_VzLdt,nG'eV:aQcddO OSDjqIBs?jxbthEhtV jxbthEhtV miMkl yxHqVw uqwehNO OSDjqIBs OkGEpb nG'eV,aQcddO:VzLdt pBvJGl uqwehNO:aQcddO!VzLdt/OSDjqIBs OuY nG'eV pBvJGl VzLdt nG'eV-miMkl OuY nG'eV.VzLdt.\n" +
                "sJG sJG?lyyOU' lyyOU'.sJG sJG sJG lyyOU' gUXqZpz_lyyOU' RFYPAmuPD BBRBm BBRBm-sJG:lyyOU' RFYPAmuPD BBRBm jlTgVn/sJG-BBRBm,RFYPAmuPD lyyOU'-SKnmodJZf SKnmodJZf!lyyOU' BBRBm BBRBm?SKnmodJZf.jlTgVn/gUXqZpz BBRBm RFYPAmuPD/BBRBm jlTgVn;sJG RFYPAmuPD jlTgVn?RFYPAmuPD-SKnmodJZf!RFYPAmuPD lyyOU' sJG_lyyOU'?jlTgVn/SKnmodJZf_sJG-jlTgVn?BBRBm SKnmodJZf_gUXqZpz?BBRBm jlTgVn-nHj SKnmodJZf;sJG lyyOU' RFYPAmuPD:BBRBm lyyOU'?lyyOU':jlTgVn_DAyMgiG lyyOU' sJG lyyOU'?RFYPAmuPD RFYPAmuPD!SKnmodJZf lyyOU' nHj/jlTgVn lyyOU' nHj?RFYPAmuPD sJG sJG BBRBm:jlTgVn sJG SKnmodJZf lyyOU' BBRBm BBRBm;sJG:SKnmodJZf,BBRBm jlTgVn,jlTgVn RFYPAmuPD jlTgVn,sJG BBRBm/SKnmodJZf-RFYPAmuPD:BBRBm BBRBm jlTgVn nHj gUXqZpz jlTgVn-RFYPAmuPD!jlTgVn?DAyMgiG;lyyOU' RFYPAmuPD sJG.sJG-SKnmodJZf?BBRBm;RFYPAmuPD SKnmodJZf.sJG jlTgVn BBRBm.RFYPAmuPD jlTgVn:lyyOU':jlTgVn sJG jlTgVn BBRBm jlTgVn?RFYPAmuPD-lyyOU'!BBRBm jlTgVn BBRBm_lyyOU' SKnmodJZf:gUXqZpz_sJG!RFYPAmuPD sJG RFYPAmuPD sJG-lyyOU';BBRBm lyyOU' sJG?jlTgVn!RFYPAmuPD,SKnmodJZf jlTgVn jlTgVn-sJG/RFYPAmuPD "));
        assertEquals(Arrays.asList("a", "of", "on"),  TopWords.top3(Stream
                .of("In a village of La Mancha, the name of which I have no desire to call to",
                        "mind, there lived not long since one of those gentlemen that keep a lance",
                        "in the lance-rack, an old buckler, a lean hack, and a greyhound for",
                        "coursing. An olla of rather more beef than mutton, a salad on most",
                        "nights, scraps on Saturdays, lentils on Fridays, and a pigeon or so extra",
                        "on Sundays, made away with three-quarters of his income.")
                .collect(Collectors.joining("\n")) ));
    }
}