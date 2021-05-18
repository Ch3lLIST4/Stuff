import sys

try:
    result_string = ""

    try:
        addr = sys.argv[1].strip()
    except IndexError as error:
        test_string = input('Paste it here:')
    
    a_char_num = 120458; #97
    z_char_num = 120483; #122
    # 120361

    for char in test_string:
        char_num = ord(char)
        if char_num >= a_char_num and char_num <= z_char_num:
            char_num = char_num - 120361
        elif char_num == 73:
            pass
        else:
            char_num = 32 
        result_string = result_string + chr(char_num)
        result_string_array = result_string.split(' ')

    for ele in result_string_array:
        if ele == '':
            result_string_array.remove(ele)
    
    print(len(result_string_array))
    print(' '.join(result_string_array))

except Exception as e:
    print(e)
