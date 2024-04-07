def number_one 
	puts "Введите входные данные"
	towers_string = gets.chomp
	work_area_tower = gets.to_i 
	towers = []
	amount_of_tower = 0 
  
	towers_string.each_char do |tower| 
	  if tower == '0'
		towers << 0
	  end
	  if tower == '1'
		towers << 1
	  end
	  amount_of_tower += 1 
	end
  
	amount_of_tower.times do |i| 
	  if towers[i] == 1
		work_area_tower.times do |j|
		  towers[i + j] = 1 if (i + j) < amount_of_tower
		  towers[i - j] = 1 if (i - j) >= 0
		end
	  end
	end
  
	is_not_zero = towers.all? { |tower| tower == 1 }
	puts is_not_zero ? "Yes" : "No"
  end
  
  def the_longest_way(route, start_end_points, last_point, length_path, max_length_path)
	start_end_points.each do |path|
	  if route[1] == path[0]
	  length_path += 1
	  the_longest_way(path, start_end_points, last_point, length_path, max_length_path)
	  end
	end
	if max_length_path[0] < length_path
	  max_length_path[0] = length_path
	  last_point[0] = route[1]
	  length_path = 0
	end
	end
  
	def number_two
	start_end_points = [
	  ["Новосибирск", "Дубай"],
	  ["Новосибирск", "Искитим"],
	  ["Искитим", "Линево"],
	  ["Искитим", "Лондон"],
	  ["Лондон", "Стамбул"],
	  ["Дубай", "Улан-Удэ"]
	]
	last_point = []
	length_path = 0
	max_length_path = []
	 max_length_path[0] = 0
	start_end_points.each do |route|
	  length_path = 0
	  the_longest_way(route, start_end_points, last_point, length_path, max_length_path)
	end
	puts last_point[0]
	end
  
  def is_length_even(number) 
	length = number.abs.to_s.length
	length.even?
  end
  
  def number_three 
	puts "Введите числа, после введения всех чисел введите 0"
	amount_numbers_even_length = 0 
  
	loop do
	  number = gets.to_i 
	  break if number.zero?
	  amount_numbers_even_length += 1 if is_length_even(number)
	end
  
	puts amount_numbers_even_length
  end
  
  puts "Выберите номер задания:"
  task_number = gets.to_i
  
  case task_number
  when 1
	number_one
  when 2
	number_two
  when 3
	number_three
  else
  end
  