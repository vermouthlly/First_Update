/**
 * atoi
 */
public class atoi {

    public static int Atoi(String str) {
        String s = "0123456789";
		str = str.trim();
		if (str.isEmpty())
			return 0;
		if (str.equals("-") || str.equals("+"))
			return 0;
		char c = str.charAt(0);
		StringBuilder sb = new StringBuilder();
		if (c == '-' || c == '+' || s.indexOf(c) != -1) {
			if (s.indexOf(c) != -1)
				sb.append(c);
			for (int i = 1; i < str.length(); i++) {
				if (s.indexOf(str.charAt(i)) != -1)
					sb.append(str.charAt(i));
				else
					break;
			}
		} else
			return 0;
		if (sb.length() == 0)
			return 0;

		try {
			if (c == '-')
				return -Integer.parseInt(sb.toString());
			else
				return Integer.parseInt(sb.toString());
		} catch (NumberFormatException e) {
			if (c == '-')
				return Integer.MIN_VALUE;
			else
				return Integer.MAX_VALUE;
		}
    }
    public static void main(String[] args) {
        System.out.println(Atoi("-435"));
    }
}