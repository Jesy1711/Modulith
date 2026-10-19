Spring Modulith : réponses aux 4 questions

Pourquoi catalog ne dépend-il pas de inventory ?
Le module catalog crée le café et annonce juste qu'un café a été créé sans savoir qui va l'écouter.
C'est inventory qui écoute cette annonce, donc c'est lui qui dépend de catalog et pas l'inverse. 

Que change @EnableAsync sur le comportement du listener ?
Sans @EnableAsync, le listener s'exécute juste après l'enregistrement du café, au même endroit que la requête, donc la requête attend qu'il ait fini.
Avec @EnableAsync, il s'exécute à part, donc la requête répond tout de suite et une erreur dans le listener ne la gêne pas.

À quoi sert l'Event Publication Registry si le listener échoue ?
Quand on crée un café, Modulith note dans la table event_publication qu'un événement doit être livré. 
Si le listener réussit, l'événement est marqué comme terminé. S'il plante, l'événement reste en attente et n'est pas perdu.

En quoi cette organisation prépare-t-elle l'extraction future d'un module en microservice ?
Chaque module est déjà séparé des autres. Il a son API et son internal caché, ses propres tables, et il ne parle aux autres que par événements. 
