package quoters;

import javax.annotation.PostConstruct;

@Profiling
@DeprecatedClass(newImpl = T1000.class)
public class TerminatorQuoter implements Quoter {
    private String message;

    @InjectRandomInt(min = 2, max = 7)
    private int repeat;

    public TerminatorQuoter() {
        System.out.println("Phase 1");
        System.out.println(repeat);
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setRepeat(int repeat) {
        this.repeat = repeat;
    }

    @PostConstruct
    public void init() {
        System.out.println("Phase 2");
        System.out.println(repeat);
    }

    @PostProxy
    public void sayQuote() {

        for (int i = 0; i < repeat; ++i) {
            System.out.println("Phase 3");
            System.out.println("Message = " + message);
        }
    }
}
