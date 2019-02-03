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
		print("Aquí imprime el arreglo completo supuestamente")
		print(self.Array)		
		self.dict = {}

		#Here we'll go through the array that has the length of the arcs 
		for i in range (len(self.Array)):
			pos1 = Array[i]
			self.hash(pos1)
		self.evaluate()

	def hash(self,p1):
		#Mental note(We use self because the method is part of the class and not of the objects)
		#Here we create the dictionary to assign every number an edge 
		self.pwd=0
		self.bicol=True

		a,b = p1.split(" ")

		if int(a) in self.dict:
			self.dict[int(a)].append(int(b))
		else:
			self.dict[int(a)] = [int(b)]

		if int(b) in self.dict:
			self.dict[int(b)].append(int(a))
		else:
			self.dict[int(b)] = [int(a)]

		print(self.dict[int(a)])
	
	def adyacency(self, list, val):

		#if (self.pwd in self.dict[num]):
		#	self.bicol=False
		#	print("No Bicolorable")
		return not val in list

	def evaluate(self):
		bicol = False
		keys = self.dict.keys()
		for i in keys:
			adjs = self.dict[i]
			#self.pwd = int(self.dict[i][0])
			if len(adjs)>1:
				aux = 0
				for j in adjs:
					for k in adjs:
						if j != k:
							bicol = self.adyacency(self.dict[j],k)

		if bicol:
			print("Bicolorable")
		else:
			print("Not Bicolorable")



n = Bicolorable()
