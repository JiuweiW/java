package sort;
/**
 * The @code Word class is an abstract data type called word that implements the Comparable interface.
 */
public class Word implements Comparable<Word>{
	private String word;
	private int score;
	/**
	 * Initializes a new Word (word, score).
	 * @param w The String for word
	 * @param s The int for score
	 */
	public Word(String w, int s)
	{
		this.word = w;
		this.score = s;
	}
	/**
	 * Return the score
	 * @return The score
	 */
	public int getScore()
	{
		return score;
	}
	/**
	 * Set the score
	 * @param s The score
	 */
	public void setScore(int s)
	{
		this.score = s;
	}
	/**
	 * Return the word
	 * @return The word
	 */
	public String getWord()
	{
		return word;
	}
	/**
	 * Set the word
	 * @param w The word
	 */
	public void setWord(String w)
	{
		this.word = w;
	}
	/**
	 * Compares this word to other word according to their score.
	 * @param w - The other word
	 * @return {@code 0} if this score equals {@code w};
	 *         {@code 1} if this score bigger than {@code w};
	 *         {@code -1} otherwise
	 */
	@Override
	public int compareTo(Word w)
	{
		// if the ranking of this is higher, return 1
		if (this.score > w.score)
			return 1;
		// if the ranking of w is higher, return -1
		else if (this.score < w.score)
			return -1;
		// with the same ranking, return 0
		return 0;
	}
	/**
	 * Return a string representation of this word.
	 * @return a string representation of this word in the format {word, score}.
	 */
	public String toString()
	{
		return "{" + this.word + "," + this.score + "}";
	}

}
