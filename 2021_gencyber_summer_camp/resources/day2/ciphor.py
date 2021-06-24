#! /usr/bin/python3
import argparse
import hashlib
import random
import sys

letter_2_num_map = {
    "a" : 0,
    "b" : 1,
    "c" : 2,
    "d" : 3,
    "e" : 4,
    "f" : 5,
    "g" : 6,
    "h" : 7,
    "i" : 8,
    "j" : 9,
    "k" : 10,
    "l" : 11,
    "m" : 12,
    "n" : 13,
    "o" : 14,
    "p" : 15,
    "q" : 16,
    "r" : 17,
    "s" : 18,
    "t" : 19,
    "u" : 20,
    "v" : 21,
    "w" : 22,
    "x" : 23,
    "y" : 24,
    "z" : 25
}

num_2_letter_map = {
    0 : "a",
    1 : "b",
    2 : "c",
    3 : "d",
    4 : "e",
    5 : "f",
    6 : "g",
    7 : "h",
    8 : "i",
    9 : "j",
    10 : "k",
    11 : "l",
    12 : "m",
    13 : "n",
    14 : "o",
    15 : "p",
    16 : "q",
    17 : "r",
    18 : "s",
    19 : "t",
    20 : "u",
    21 : "v",
    22 : "w",
    23 : "x",
    24 : "y",
    25 : "z"
}

english_letter_freq = {
    "a" : 8.34,
    "b" : 1.54,
    "c" : 2.73,
    "d" : 4.14,
    "e" : 12.60,
    "f" : 2.03,
    "g" : 1.92,
    "h" : 6.11,
    "i" : 6.71,
    "j" : 0.23,
    "k" : 0.87,
    "l" : 4.24,
    "m" : 2.53,
    "n" : 6.80,
    "o" : 7.70,
    "p" : 1.66,
    "q" : 0.09,
    "r" : 5.68,
    "s" : 6.11,
    "t" : 9.37,
    "u" : 2.85,
    "v" : 1.06,
    "w" : 2.34,
    "x" : 0.20,
    "y" : 2.04,
    "z" : 0.06
}

def analyze_text(text):
    '''
        This function reads through a text and calculates the counts for each letter a-z.
        Note: This is case insensitive. This returns a map of letters and the total count
        of appearance in the text.
    '''
    stats = {}
    for c in list(text):
        c = c.lower()
        if c in letter_2_num_map:
            if c not in stats:
                stats[c] = 1
            else:
                stats[c] += 1
    return stats

def print_stats(stats):
    '''
        This Function will print out the letter counts. The expectation is that a mapping
        of letters to counts is provided to this function. Thus, the analyze_text function
        should be called prior to calling this function.
    '''
    assert(stats is not None)
    letters = letter_2_num_map.keys()
    print("Character Frequencies: ")
    print("index   char   count\t   %\t\t   English %")
    sum = 0
    for c in stats:
        sum += stats[c]
    index = 0
    for l in letters:
        if l in stats:
            print("  {} \t {}  =  {}\t-- {:.4f} %\t--\t{} %".format(index, l, stats[l],(stats[l] / sum) * 100, english_letter_freq[l]))
        else:
            print("  {} \t {}  =  0\t-- 0.0\t  % \t-- \t{} %".format(index, l, english_letter_freq[l]))
        index+=1

def caesar_encrypt(plain_text, shift):
    '''
        Returns a cipher_text where each letter from the plain_text has been shifted "shift"
        characters to the right.
    '''
    if shift < 1:
        raise ValueError("A Caesar Cipher shift must be a positive integer greater than 0.")
    cipher_text = ""
    for c in list(plain_text):
        cipher_text += cipher_shift(c, shift)
    return cipher_text

def caesar_decrypt(cipher_text, shift):
    '''
        Returns an assumed plain_text where each letter from the cipher_text has been shifted "shift"
        characters to the left.
    '''
    if shift < 1:
        raise ValueError("A Caesar Cipher shift must be a positive integer greater than 0.")
    shift *= -1
    plain_text = ""
    for c in list(cipher_text):
        plain_text += cipher_shift(c, shift)
    return plain_text

def cipher_shift(c, shift):
    '''
        This is the actual shift function. Given a character (c) and a shift, it will find
        the new character that is shift distant from c. The reutrned character is kept in-bounds
        using a modulus operation. Note, that modulus operations (remainders) can be zero. Thus,
        the alphabet mapping starts from zero and counts up to 25 (instead of 26), but still has
        26 total entries (size of the alphabet).
    '''
    num = char2num(c)
    if num in num_2_letter_map: 
        return num_2_letter_map[(num + shift) % len(letter_2_num_map)]
    else:
        return c

def key_encrypt(plain_text, key):
    """
        Basic key encryption algorithm. A key is compared to a plain_text. Each letter in
        the key is used to create a shift that is applied to the plain_text to produce the
        cipher_text. The shift value for alphabet chars is that of the mapping. Any other chars
        in the key are converted to their ASCII numeric equivalent.
        Also, only alphabet characters in the message are actually shifted. The key is cycled
        through as many times as necessary to shift the entire plain_text.
    """
    if len(key) < 1:
        raise ValueError("The key in a key cipher must be one or more characters long!")
    cipher_text = ""
    keys = list(key)
    for c in list(plain_text):
        if c.lower() in letter_2_num_map:
            key_char = keys.pop(0)
            shift = ord(key_char)
            if key_char in letter_2_num_map:
                shift = char2num(key_char)            
            cipher_text += cipher_shift(c, shift)
            keys.append(key_char)
        else:
            cipher_text += c
    return cipher_text

def key_decrypt(cipher_text, key):
    '''
        Identical to key_ecnrypt but it shifts to the left rather than to the right.
    '''
    if len(key) < 1:
        raise ValueError("The key in a key cipher must be one or more characters long!")
    plain_text = ""
    keys = list(key)
    for c in list(cipher_text):
        if c.lower() in letter_2_num_map:
            key_char = keys.pop(0)
            shift = ord(key_char)
            if key_char in letter_2_num_map:
                shift = char2num(key_char)    
            shift = shift *  -1
            plain_text += cipher_shift(c, shift)
            keys.append(key_char)
        else:
            plain_text += c
    return plain_text

def get_signature(text):
    '''
        Returns a signature of the provide text. Note, the signature returned is only
        16 characters of a much larger hash. This was done to simplify the idea of
        a signature for educational purposes. Obviously, this makes collisions in
        hash signatures much more likely. Returns a hexadecimal string.
    '''
    hasher = hashlib.sha256()
    hasher.update(text.encode("utf-8"))
    signature = hasher.digest()[0:16]
    return signature.hex()

def char2num(c):
    """
        Because we are using a simple alphabet (lower-case a-z) we need a simple
        method to find the number for each letter. Keep in mind that characters
        in the program have some encoding (ASCII or Unicode). Thus, we need our
        own function to translate to our mapping. The simple alphabet is used instead
        of ASCII because it is clearer as a teaching tool to see what is going on.
        If ASCII were used the total possible values grow to 128 and cryptanalysis
        becomes much more subtle.
    """
    the_char = c.lower()
    if the_char in letter_2_num_map:
        return letter_2_num_map[the_char]
    else:
        return -1

def num2char(n):
    """
        The inverse function to char2num. This will produce the char based on a number.
        Thus, char2num will provide the number, dependent on the mapping in ciphor,
        and num2char will produce the character for the given number.
    """
    if n >= 0 and n < len(num_2_letter_map):
        return num_2_letter_map[n]
    else:
        return " "

# Begin Testing Functions. These are unit tests to test the functions of ciphor.
def test_ciphor():
    test_caesar()
    test_key()
    test_stats()
    print("tests complete!")

def test_caesar():
    assert(caesar_encrypt("abcdefghijklmnopqrstuvwxyz", 4) == "efghijklmnopqrstuvwxyzabcd")
    ptext = "Hello 2 The World!"
    assert(caesar_encrypt("z", 1) == 'a')
    assert(caesar_decrypt("a", 1) == "z")
    for i in range(1, 128):
        assert(caesar_decrypt(caesar_encrypt(ptext, i), i) == ptext.lower())
    print("Caesar Cipher tests successful!")

def test_key():
    ptext = "Hello 1n The Summer?"
    for i in range(1, len(ptext)):
        key = ""
        for j in range(0, i):
            key += chr(random.randint(0,128))
        assert(key_decrypt(key_encrypt(ptext, key), key) == ptext.lower())
    print("Key cipher tests complete.")

def test_stats():
    gatsby_text = '''
        The Project Gutenberg eBook of The Great Gatsby, by F. Scott Fitzgerald

        This eBook is for the use of anyone anywhere in the United States and
        most other parts of the world at no cost and with almost no restrictions
        whatsoever. You may copy it, give it away or re-use it under the terms
        of the Project Gutenberg License included with this eBook or online at
        www.gutenberg.org. If you are not located in the United States, you
        will have to check the laws of the country where you are located before
        using this eBook.

        Title: The Great Gatsby

        Author: F. Scott Fitzgerald

        Release Date: January 17, 2021 [eBook #64317]
        [Most recently updated: January 24 2021]

        Language: English

        Character set encoding: UTF-8

        Produced by: Alex Cabal for the Standard Ebooks project, based on a
                     transcription produced for Project Gutenberg Australia.

        *** START OF THE PROJECT GUTENBERG EBOOK THE GREAT GATSBY ***
        The Great Gatsby
        by
        F. Scott Fitzgerald
                                      Once again
                                          to
                                         Zelda

          Then wear the gold hat, if that will move her;
          If you can bounce high, bounce for her too,
          Till she cry "Lover, gold-hatted, high-bouncing lover,
          I must have you!"
          Thomas Parke d'Invilliers

        In my younger and more vulnerable years my father gave me some advice
        that I've been turning over in my mind ever since.

        "Whenever you feel like criticizing anyone," he told me, "just
        remember that all the people in this world haven't had the advantages
        that you've had."

        He didn't say any more, but we've always been unusually communicative
        in a reserved way, and I understood that he meant a great deal more
        than that. In consequence, I'm inclined to reserve all judgements, a
        habit that has opened up many curious natures to me and also made me
        the victim of not a few veteran bores. The abnormal mind is quick to
        detect and attach itself to this quality when it appears in a normal
        person, and so it came about that in college I was unjustly accused of
        being a politician, because I was privy to the secret griefs of wild,
        unknown men. Most of the confidences were unsought--frequently I have
        feigned sleep, preoccupation, or a hostile levity when I realized by
        some unmistakable sign that an intimate revelation was quivering on
        the horizon; for the intimate revelations of young men, or at least
        the terms in which they express them, are usually plagiaristic and
        marred by obvious suppressions. Reserving judgements is a matter of
        infinite hope. I am still a little afraid of missing something if I
        forget that, as my father snobbishly suggested, and I snobbishly
        repeat, a sense of the fundamental decencies is parcelled out
        unequally at birth.

        And, after boasting this way of my tolerance, I come to the admission
        that it has a limit. Conduct may be founded on the hard rock or the
        wet marshes, but after a certain point I don't care what it's founded
        on. When I came back from the East last autumn I felt that I wanted
        the world to be in uniform and at a sort of moral attention forever; I
        wanted no more riotous excursions with privileged glimpses into the
        human heart. Only Gatsby, the man who gives his name to this book, was
        exempt from my reaction--Gatsby, who represented everything for which I
        have an unaffected scorn. If personality is an unbroken series of
        successful gestures, then there was something gorgeous about him, some
        heightened sensitivity to the promises of life, as if he were related
        to one of those intricate machines that register earthquakes ten
        thousand miles away. This responsiveness had nothing to do with that
        flabby impressionability which is dignified under the name of the
        "creative temperament"--it was an extraordinary gift for hope, a
        romantic readiness such as I have never found in any other person and
        which it is not likely I shall ever find again. No--Gatsby turned out
        all right at the end; it is what preyed on Gatsby, what foul dust
        floated in the wake of his dreams that temporarily closed out my
        interest in the abortive sorrows and short-winded elations of men.


        My family have been prominent, well-to-do people in this Middle
        Western city for three generations. The Carraways are something of a
        clan, and we have a tradition that we're descended from the Dukes of
        Buccleuch, but the actual founder of my line was my grandfather's
        brother, who came here in fifty-one, sent a substitute to the Civil
        War, and started the wholesale hardware business that my father
        carries on today.

        I never saw this great-uncle, but I'm supposed to look like him--with
        special reference to the rather hard-boiled painting that hangs in
        father's office. I graduated from New Haven in 1915, just a quarter of
        a century after my father, and a little later I participated in that
        delayed Teutonic migration known as the Great War. I enjoyed the
        counter-raid so thoroughly that I came back restless. Instead of being
        the warm centre of the world, the Middle West now seemed like the
        ragged edge of the universe--so I decided to go East and learn the bond
        business. Everybody I knew was in the bond business, so I supposed it
        could support one more single man. All my aunts and uncles talked it
        over as if they were choosing a prep school for me, and finally said,
        "Why--ye-es," with very grave, hesitant faces. Father agreed to finance
        me for a year, and after various delays I came East, permanently, I
        thought, in the spring of twenty-two.

        The practical thing was to find rooms in the city, but it was a warm
        season, and I had just left a country of wide lawns and friendly
        trees, so when a young man at the office suggested that we take a
        house together in a commuting town, it sounded like a great idea. He
        found the house, a weather-beaten cardboard bungalow at eighty a
        month, but at the last minute the firm ordered him to Washington, and
        I went out to the country alone. I had a dog--at least I had him for a
        few days until he ran away--and an old Dodge and a Finnish woman, who
        made my bed and cooked breakfast and muttered Finnish wisdom to
        herself over the electric stove.
    '''

    stats = analyze_text(gatsby_text)
    print_stats(stats)

### End Unit tests

### Begin command Line Processing
def process_command_line():
    parser = argparse.ArgumentParser("ciphor.py")
    parser.add_argument("-c", "--caesar", dest="caesar_shift", type=int, help="designate \
        the caesar cipher as your cipher. You must set a shift. The shift is an integer greater than 0. \
        You may only use one of -c or -k, not both.")
    parser.add_argument("-d", "--decrypt", dest="decrypt_flag", action="store_true", help="designate \
        decryption as the action to take. Note: you may only use one of -d or -e, not both.")
    parser.add_argument("-e", "--encrypt", dest="encrypt_flag", action="store_true", help="designate \
        encryption as the action to take. Note: you may only use one of -d or -e, not both.")
    parser.add_argument("-f", "--file", dest="source_file", help="A plain text or \
        cipher text for encrypt/decryption.")
    parser.add_argument("-k", "--key", dest="key", help="designate a key cipher as the cipher. \
        a key is usually a word like my_password or cat that you can easily remember. \
        You may only use -c or -k, not both. This argument expects a key of one or more characters.")
    parser.add_argument("-o", "--output", dest="output",
        help="Output a cipher text or plain text (depending on the operation.")
    parser.add_argument("-s", "--stats_flag", dest="stats_flag",  action="store_true",
        help="Print the statistics of the input text.")
    parser.add_argument("-S", "--signature", dest="sig_flag", action="store_true",
        help="Print a signature for the message and cipher message respectively.")
    parser.add_argument("-t", "--test", dest="test_flag",  action="store_true",
        help="Execute unit tests, print results, then exit.")
    parser.add_argument("message", nargs="*", help="Optional plain or cipher text.")
    if len(sys.argv) < 2:
        parser.print_help(sys.stderr)
        quit()
    return parser.parse_args()

def check_errors(args):
    if args.test_flag:
        test_ciphor()
        quit()
    args.caesar_flag = False
    args.key_flag = False
    if args.caesar_shift is not None:
        args.caesar_flag = True
    if args.key is not None:
        args.key_flag = True
    if args.caesar_flag and args.key_flag:
        raise SystemExit("You cannot do both a caesar cipher and a key cipher at the same time. Please choose just one.")
    if args.encrypt_flag and args.decrypt_flag:
        raise SystemExit("You cannot both encrypt and decrypt at once. Please choose just one.")


### End Command Line processing
 
def main():
    '''
        This function represents the main function of the program. Basically,
        Command line arguments are parsed, then a message will be ciphered or
        deciphered dependeding on the options used. Optionally, a messages
        hash or statistics might be printed. An error is printed when recognized.
    '''
    args = process_command_line()
    check_errors(args)
    message = ' '.join(args.message)
    ciphered_message = ""
    if "source_file" in args and args.source_file is not None:
        print("reading file!")
        try:
            with open(args.source_file, 'r') as fd:
                message = fd.read()
        except Exception as e:
            print(e)
            raise SystemExit("There was a problem reading the file {}. It may be there is \
                   a special character in the file (outside normal ASCII). \
                   ciphor currently supports only basic encodings. You may try \
                   finding and removing the offending character or using a different file.".format(args.source_file))
                   
        print("message is: ", message)
    if message is None:
        raise SystemExit("No message to encrypt, decrypt, or get stats for!")
    if args.sig_flag:
        print("Message Signature: {}".format(get_signature(message)))
    if args.encrypt_flag:
        if args.caesar_flag:
            ciphered_message = caesar_encrypt(message, args.caesar_shift)
        else:
            ciphered_message = key_encrypt(message, args.key)
    elif args.decrypt_flag:
        if args.caesar_flag:
            ciphered_message = caesar_decrypt(message, args.caesar_shift)
        else:
            ciphered_message = key_decrypt(message, args.key)
    if args.stats_flag:
        stats = analyze_text(message)
        print_stats(stats)
    if args.output is not None:
        with open(args.output, 'w') as fd:
            fd.write(ciphered_message)
    elif len(ciphered_message) > 0:
        if args.sig_flag:
            print("Ciphered Message Signature: {}".format(get_signature(message)))
        print("Ciphered Message:")
        print(ciphered_message)
        
    
 
if __name__=="__main__":
    main()
