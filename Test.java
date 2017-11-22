import java.util.ArrayList;

public class Test {
	public static void main(String[] args) {
		String GivenWord="2jjjj79dcdcdc9";
		ArrayList<String> Words = FindNonDigitSequenceOfChar ( GivenWord,1 );
		
		if(Words!=null) {
		  for(String Word :Words) {
			  System.out.println(Word);
		  }
		}
	
	}
	private static ArrayList<String> FindNonDigitSequenceOfChar( String givenWord, int MinimumSize ){
		
		assert (givenWord != null) : "Given Word is null";
		assert (givenWord.length() != 0) : "Given Word has zero character";
		assert (MinimumSize>= 0 ):"negative size number";
		
		int MinimumWordSizetoFindaSubString = MinimumSize + 3;
		if( givenWord.length() < MinimumWordSizetoFindaSubString ) {
			System.out.print("no sub array found");
			return null;
		}
		
		ArrayList<String> NonDigitSequences  = new ArrayList<String>();
		boolean firstNumberFound = false;
		int FirstNumberPlace = 0;
		final int StartingPoint = 0;
		final int EndingPoint = givenWord.length();
		
		for( int StringIndex = StartingPoint; StringIndex < EndingPoint; StringIndex++) {
			char charread = givenWord.charAt( StringIndex);
			if( isNumeric( charread )) {
				if( firstNumberFound == false ) {
					firstNumberFound = true;
					FirstNumberPlace = StringIndex;
					
				}
				else {
					    char leftcharacter =givenWord.charAt( FirstNumberPlace );
					    char rightcharacter = givenWord.charAt( StringIndex );
					    
					if( CompareDigits( leftcharacter , rightcharacter ) ) {
						
						String foundString = CopyString( givenWord, FirstNumberPlace,   
                                StringIndex );
				
						if( foundString.length() > MinimumSize ) {
							NonDigitSequences.add( foundString );
						}
						
					}
					FirstNumberPlace = StringIndex;	
				}						
			}
		}
		
		assert ( NonDigitSequences != null ): "Null SubString Returned";
		
		
		return NonDigitSequences;
	}
	
	
	private static boolean isNumeric( Character givencharacter ) {
		assert ( givencharacter!=null ) : " NULL character error";
		
		if( Character.isDigit( givencharacter )) {
			return true;
			
		}
		else {
			return false;
		}
		
	} 
	
	
	private static boolean CompareDigits( char leftcharacter, char rightcharacter ) {
		
		if( leftcharacter >= rightcharacter ) {
			return false;
		}
		else {
			return true;
		}
		
	}
	
	
	private static String CopyString( String given, int leftplace, int rightplace ) {
		assert ( given!=null ) : " NULL String error";
		
		String Copied="";
		
		for( int k=leftplace+1; k < rightplace; k++ ) {
			Copied = Copied + given.charAt(k);
		}
		
		
		assert ( Copied != null ):" NULL Word Found returned";
		
		return Copied;	
	}

}
