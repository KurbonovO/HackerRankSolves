package crackingTheCodingInterview;

public class URLifyBeck {
	public String uRLifyBeck(String url) {

		url = url.trim();

		url = url.replaceAll("\\s", "%20");

		return url;
	}
	public static void main(String[] args) {

		URLifyBeck uRLifyBeck = new URLifyBeck();
		System.out.println(uRLifyBeck.uRLifyBeck("Mr John Smith   "));
	}
}
