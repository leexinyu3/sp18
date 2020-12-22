public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> lld1 = new LinkedListDeque<Character>();
        int i = 0;
        char tmp;
        for (i = 0; i < word.length(); i++) {
            tmp = word.charAt(i);
            lld1.addLast(tmp);
        }
        return lld1;
    }

    /**
     * OffBy0
     */
    public boolean isPalindrome(String word){
        Deque<Character> deque = wordToDeque(word);

        return isPalindrome_re(deque);
    }


    private boolean isPalindrome_re(Deque<Character> deque){
        if (deque.size() <= 1) {
            return true;
        }
        if (!deque.removeFirst().equals(deque.removeLast())) {
            return false;
        }
        return isPalindrome_re(deque);
    }

/**
 * OffByOne/N
 */
public boolean isPalindrome(String word, CharacterComparator cc) {
    Deque<Character> deque = wordToDeque(word);
    return isPalindrome_re(deque, cc);
}

private boolean isPalindrome_re(Deque<Character> deque ,CharacterComparator cc){

    if (deque.size() <= 1) {
        return true;
    }
    if (!cc.equalChars(deque.removeFirst(),deque.removeLast()))
        return false;
    return isPalindrome_re(deque,cc);
}



}