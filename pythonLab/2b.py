def find_maximum(numbers):
    maximum = numbers[0]
    for num in numbers:
        if num > maximum:
            maximum = num
    return maximum


numStr = input("enter nos")
numStrList = numStr.split()
numbers = []
for n in numStrList:
    num = int(n)
    numbers.append(num)

max_num = find_maximum(numbers)
print("The maximum number is:", max_num)
