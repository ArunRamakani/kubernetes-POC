#  Setup mysql persistent docker with GCE 


	gcloud compute disks create --size 200GB mysql-disk

	kubectl create secret generic mysql --from-literal=password=mySql

	kubectl create -f gce-volume.yaml

	kubectl create -f pvc-claim.yaml 

	kubectl create -f mysql.yaml

	kubectl create -f mysql-service.yaml


	#####################################

	For Clean up 

	kubectl delete deployment,svc mysql
	
	kubectl delete pvc mysql-pv-claim
	
	kubectl delete pv mysql-pv
	
	kubectl delete secret mysql

	gcloud compute disks delete mysql-disk


	####################################
	
#  Setup microservices 


	kubectl create -f inventoryPod.yaml 
	
	kubectl create -f purchasePod.yaml
	
	kubectl create -f inventoryService.yaml 
	
	kubectl create -f purchaseService.yaml


	#####################################

	For Clean up 

	kubectl delete deployment inventory
	
	kubectl delete deployment purchase
	
	kubectl delete service inventory
	
	kubectl delete service purchase
	

	####################################


