class Bicolorable:
	#Author= Felipe Ríos López & Santiago Gil Zapata
	
	def __init__(self):
		#init is the constructor of the class
		
		#n= Number of nodes
		n = int(input("Put the number of nodes: "))
		#Maximum possible nodes are 200
		if n > 200:
			#If n is over 200, the program will restart
			k = Bicolorable()
			
		#a= Number of arcs
		a = int(input("Put the number of arcs: "))

		if  a > n:
			#If a is higher than N (which is impossible) the program will restart
			k= Bicolorable()

		#Creating a global array
		self.Array = []
		
		#Getting everything into the array
		for i in range(a):
			#connect = connections 
			connect = input("Put the edges: ")
			#append = add 
			self.Array.append(connect)
		#Calling the method that will divide the array
		self.divideArray(self.Array)

	def divideArray(self,Array):
		#Dividing the array by parts
		print(self.Array)		
		self.dict = {}

		#Here we'll go through the array that has the length of the arcs 
		for i in range (len(self.Array)):
			pos1 = Array[i]
			#//*After calling hash, where we create a dictionary that 
			#contains lists, then we call evaluate that will tell us if it's bicolorable or not.*//
			self.hash(pos1)
		self.evaluate()

	def hash(self,p1):
		#Mental note(We use self because the method is part of the class and not of the objects)
		#Here we create the dictionary to assign every number an edge 
		#boolean bicol
		self.bicol=True

		a,b = p1.split(" ")
		#a = the first number of the list that we will divide for example: "1 0"; a=1, b =0.
		#If a(the firs is in the dictonary, then add, else, create it. We need this avoiding overwriting the keys
		if int(a) in self.dict:
			self.dict[int(a)].append(int(b))
		else:
			self.dict[int(a)] = [int(b)]

		if int(b) in self.dict:
			self.dict[int(b)].append(int(a))
		else:
			self.dict[int(b)] = [int(a)]

		print(self.dict[int(a)])
	
	def adjacency(self, list, val):
		#The list is a part of the array
		#Val is the number of the edge we are going to compare
		#If val is not on the list, then it's bicolorable, else, it's not. 
		return not val in list

	def evaluate(self):
		bicol = False
		#this is made to get the key in every dictionary (a list of keys)
		keys = self.dict.keys()
		#i take the value of the first key, the second key,etc...
		for i in keys:
			#adjs takes the number of the key everytime it gets in the loop
			adjs = self.dict[i]
			#if len (subjacents of every key that contain a list of subjacents of an edge) is just one, it has no risk of being no bicolorable
			if len(adjs)>1:
				for j in adjs:
					#j for the first number in the list
					for k in adjs:
						#k to iterate that first number
						if j != k
							#calling the method adjacency
							bicol = self.adjacency(self.dict[j],k)

		if bicol:
			print("Bicolorable")
		else:
			print("Not Bicolorable")


#Initializing
n = Bicolorable()
