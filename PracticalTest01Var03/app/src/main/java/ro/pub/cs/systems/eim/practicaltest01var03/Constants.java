package ro.pub.cs.systems.eim.practicaltest01var03;

public class Constants {
    final public static String NUMBER_1 = "N1";
    final public static String NUMBER_2 = "N2";
    final public static String RESULT = "R";
    final public static String OPERATION = "OP";
    final public static int SECONDARY_ACTIVITY_REQUEST_CODE = 2;

    final public static String[] actionTypes = {
            "ro.pub.cs.systems.eim.practicaltest01var03.sum",
            "ro.pub.cs.systems.eim.practicaltest01var03.difference"
    };

    final public static int SERVICE_STOPPED = 0;
    final public static int SERVICE_STARTED = 1;

    final public static String PROCESSING_THREAD_TAG = "[Processing Thread]";

    final public static String BROADCAST_RECEIVER_EXTRA = "message";
    final public static String BROADCAST_RECEIVER_TAG = "[Message]";
}
