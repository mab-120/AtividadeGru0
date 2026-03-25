import {View, Text, TouchableOpacity, StyleSheet} from 'react-native';

export default function ContactScreen({ navigation }) {
  return (
    <View style={styles.container}>
    <Text style={styles.title}>Contato</Text>

    <Text style={styles.text}>Aqui estão os meios de contato disponíveis:
     </Text>
     <Text style={styles.text}>Whatsapp: xx xxxxx-xxxx
     </Text>
          <Text style={styles.text}>e-mail: empresa@gmail.com
     </Text>


        <TouchableOpacity
    style={styles.button}
    onPress={() => navigation.navigate('Final')}>
    <Text style={styles.buttonText}>Final</Text>
    </TouchableOpacity>

    </View>
  );
}

const styles=StyleSheet.create({
  container: {
    flex: 1,
    justifyContent:'center',

    display: 'flex',
    padding: 20,
    backgroundColor: '#fff',
   
  },
  title: {
    fontSize: 26,
    fontWeight:'bold',
  },
  text: {
    marginVertical: 15,
    textAlign: 'left'
  },
  button: {
    backgroundColor: '#556B2F',
    padding: 16,
    borderRadius: 100,
    alignItems: 'center',
    width: '80%',
    marginVertical: 20,
  },
  buttonText: {
    color: '#fff',
    fontWeight: 'bold',
    fontSize: 20,
  }
});