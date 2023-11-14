numbers_str = input("Enter a list of numbers, separated by spaces: ")
numbers_str_list = numbers_str.split()

numbers = []
for num_str in numbers_str_list:
    num = int(num_str)
    numbers.append(num)

even_sum = 0
for num in numbers:
    if num % 2 == 0:
        even_sum += num

print("The sum of even numbers is:", even_sum)
