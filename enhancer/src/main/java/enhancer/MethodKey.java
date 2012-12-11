package enhancer;

public class MethodKey {

    public final String key;

    public MethodKey(String clazz, String methodName, Object[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append(clazz);
        sb.append(':');
        sb.append(methodName);
        sb.append(':');
        for (Object arg : args) {
            sb.append(':');
            if (arg != null) {
                sb.append(arg.toString());
            }
            sb.append(':');
        }
        this.key = sb.toString();
    }
}
