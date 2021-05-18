# in lan luot khong xai vong lap, khong de quy, khong iterator

n = int(input('enter n : '))
t = 1
i = 0
s = 'i+=1\nprint(i,end=" ")\n'
e = 'i=0\nexec(s*t)\nprint()\nt+=1\n'*n
exec(e)
