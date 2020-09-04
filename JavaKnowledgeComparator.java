// This class implements a dual sorting comparator, which
// will sort a list by section, then by java knowledge
// Benjamin Ramon
// 827002250
// bramon24@tamu.edu

package driver;

import java.util.*;
import java.lang.*;

public class JavaKnowledgeComparator implements Comparator<CMSC314Student> {
    public int compare(CMSC314Student a, CMSC314Student b) {
        int x1 = a.getSection();
        int x2 = b.getSection();
        int iComp = Integer.compare(x1, x2);
        // our first check, highest priority is section
        if (iComp != 0) return iComp;
        int y1 = a.getJavaKnowledge();
        int y2 = b.getJavaKnowledge();
        return Integer.compare(y1, y2);
    }
}
