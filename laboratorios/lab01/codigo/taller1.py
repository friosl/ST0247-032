class Bicolorable:
	
	def __init__(self):
		n = int(input("Put the number of nodes: "))
		#Maximum possible nodes are 200
		if n > 200:
			k = Bicolorable()
		a = int(input("Put the number of arcs: "))

		if  a > n:
			k= Bicolorable()

		#Creating a global array
		self.Array = []

		for i in range(a):
			#connect = connections 
			connect = input("Put the edges: ")
			#append = add 
			self.Array.append(connect)
		self.divideArray(self.Array)

	def divideArray(self,Array):
		print(self.Array)		
		self.dict = {}

		#Here we'll go through the array that has the length of the arcs 
		for i in range (len(self.Array)):
			pos1 = Array[i]
			self.hash(pos1)
		#self.comparison()

	def hash(self,p1):
		#Mental note(We use self because the method is part of the class and not of the objects)
		#Here we create the dictionary to assign every number an edge 

		a,b = p1.split(" ")
		if int(a) in self.dict:
			self.dict[int(a)].append(int(b))
			print("añadiendo mas veces")
		else:
			self.dict[int(a)] = [int(b)] 
		print(self.dict[int(a)])
		print("añadiendo por primera vez")


	#def comparison():


n = Bicolorable()