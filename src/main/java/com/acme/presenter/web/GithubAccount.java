package com.acme.presenter.web;

import java.util.Scanner;

import org.scribe.builder.ServiceBuilder;
import org.scribe.builder.api.DefaultApi10a;
import org.scribe.builder.api.DefaultApi20;
import org.scribe.builder.api.GoogleApi;
import org.scribe.extractors.AccessTokenExtractor;
import org.scribe.model.OAuthConfig;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.model.Verifier;
import org.scribe.oauth.OAuthService;
import org.scribe.utils.OAuthEncoder;

public class GithubAccount {
	//private static final String NETWORK_NAME = "Google";
	//private static final String AUTHORIZE_URL = "https://www.google.com/accounts/OAuthAuthorizeToken?oauth_token=";
	//private static final String PROTECTED_RESOURCE_URL = "https://docs.google.com/feeds/default/private/full/";
	//private static final String SCOPE = "https://docs.google.com/feeds/";

	public static void main(String[] args) {
	    // Replace these with your own api key and secret
	    String apiKey = "your_app_id";
	    String apiSecret = "your_api_secret";
	    OAuthService service = new ServiceBuilder()
	                                  .provider(GitHubApi.class)
	                                  .apiKey("1bbec341e648577faabe")
	                                  .apiSecret("68cb0e75ba753690da2c27e813e4c65df097f2be")
	                                  .callback("http://localhost:8080/presenter/auth/github/login")
	                                  .build();
	    Scanner in = new Scanner(System.in);

	    //System.out.println("=== " + NETWORK_NAME + "'s OAuth Workflow ===");
	    System.out.println();

	    // Obtain the Authorization URL
	    System.out.println("Fetching the Authorization URL...");
	    String authorizationUrl = service.getAuthorizationUrl(null);
	    System.out.println("Got the Authorization URL!");
	    System.out.println("Now go and authorize Scribe here:");
	    System.out.println(authorizationUrl);
	    System.out.println("And paste the authorization code here");
	    System.out.print(">>");
	    Verifier verifier = new Verifier(in.nextLine());
	    System.out.println();
	    
	    // Trade the Request Token and Verfier for the Access Token
	    System.out.println("Trading the Request Token for an Access Token...");
	    Token accessToken = service.getAccessToken(null, verifier);
	    System.out.println("Got the Access Token!");
	    System.out.println("(if your curious it looks like this: " + accessToken + " )");
	    System.out.println();

	    // Now let's go and ask for a protected resource!
	    /*System.out.println("Now we're going to access a protected resource...");
	    OAuthRequest request = new OAuthRequest(Verb.GET, PROTECTED_RESOURCE_URL);
	    service.signRequest(accessToken, request);
	    Response response = request.send();
	    System.out.println("Got it! Lets see what we found...");
	    System.out.println();
	    System.out.println(response.getCode());
	    System.out.println(response.getBody());

	    System.out.println();
	    System.out.println("Thats it man! Go and build something awesome with Scribe! :)");*/
	}
	
	public static class GitHubApi extends DefaultApi20 {

		@Override
		public String getAccessTokenEndpoint() {
			return "https://github.com/login/oauth/access_token";
		}

		@Override
		public String getAuthorizationUrl(OAuthConfig config) {
			return String.format("https://github.com/login/oauth/authorize?client_id=%s&redirect_uri=%s", config.getApiKey(), OAuthEncoder.encode(config.getCallback()));
		}

		@Override
		public Verb getAccessTokenVerb() {
			// TODO Auto-generated method stub
			return Verb.POST;
		}
		
	}
}
